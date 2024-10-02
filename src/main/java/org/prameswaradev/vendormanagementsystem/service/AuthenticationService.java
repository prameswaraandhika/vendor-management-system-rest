package org.prameswaradev.vendormanagementsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prameswaradev.vendormanagementsystem.dto.LoginDto;
import org.prameswaradev.vendormanagementsystem.dto.RefreshTokenDto;
import org.prameswaradev.vendormanagementsystem.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public TokenDto login(LoginDto loginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(), loginDto.getPassword()));
            return tokenService.generateTokenPairs(loginDto.getUsername());
        } catch (BadCredentialsException e) {
            log.error("Invalid credentials for user: {}", loginDto.getUsername(), e);
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    public TokenDto refreshToken(RefreshTokenDto refreshTokenDto) {
        return tokenService.generateTokenPairsViaRefreshToken(refreshTokenDto.getRefreshToken());
    }
}
