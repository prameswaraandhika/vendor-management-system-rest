package org.prameswaradev.vendormanagementsystem.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.TokenDto;
import org.prameswaradev.vendormanagementsystem.dto.UserDto;
import org.prameswaradev.vendormanagementsystem.entity.TokenEntity;
import org.prameswaradev.vendormanagementsystem.exception.NotFoundException;
import org.prameswaradev.vendormanagementsystem.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;
    private final UserService userService;
    @Value("${jwt-variables.key}")
    private String jwtKey;

    @Value("${jwt-variables.issuer}")
    private String jwtIssuer;

    @Value("${jwt-variables.expires-access-token-minute}")
    private long accessTokenExpiryDuration;

    @Value("${jwt-variables.expires-refresh-token-minute}")
    private long refreshTokenExpiryDuration;


    public TokenDto generateTokenPairs(String username) {
        UserDto user = userService.getDtoByUsername(username);
        return getTokenDto(user);
    }

    public TokenDto generateTokenPairsViaRefreshToken(String refreshTokenValue) {
        var existingRefreshToken = tokenRepository.findTokenByTokenAndValidTrue(refreshTokenValue);
        if (existingRefreshToken.isEmpty()) {
            throw new NotFoundException("refresh token not found!");
        }
        verifyRefreshToken(existingRefreshToken.get());
        tokenRepository.delete(existingRefreshToken.get());
        var user = userService.getDtoByUsername(existingRefreshToken.get().getUsername());
        return getTokenDto(user);
    }

    private TokenDto getTokenDto(UserDto user) {
        var accessToken = generateAccessToken(user.getUsername());
        var refreshToken = generateRefreshToken(user.getUsername());
        return TokenDto.builder()
                .refreshToken(refreshToken)
                .accessToken(accessToken)
                .user(user)
                .build();
    }

    public String generateAccessToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(
                        new Date(
                                System.currentTimeMillis()
                                        + Duration.ofMinutes(accessTokenExpiryDuration).toMillis()))
                .withIssuer(jwtIssuer)
                .sign(Algorithm.HMAC256(jwtKey.getBytes()));
    }

    public DecodedJWT verifyJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtKey.getBytes(StandardCharsets.UTF_8));
        JWTVerifier verifier = JWT.require(algorithm).build();
        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String generateRefreshToken(String username) {
        Instant expirationTime = Instant.now().plus(Duration.ofMinutes(refreshTokenExpiryDuration));
        TokenEntity refreshToken = new TokenEntity();
        refreshToken.setUsername(username);
        refreshToken.setValid(true);
        refreshToken.setExpiryDate(expirationTime);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = tokenRepository.save(refreshToken);
        return refreshToken.getToken();
    }

    public void verifyRefreshToken(TokenEntity token) {
        if (token.getExpiryDate().isBefore(Instant.now())) {
            throw new RuntimeException("Token has expired and cannot be used!");
        }
    }
}
