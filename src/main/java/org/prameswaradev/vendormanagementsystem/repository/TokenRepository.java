package org.prameswaradev.vendormanagementsystem.repository;

import org.prameswaradev.vendormanagementsystem.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, String> {
    Optional<TokenEntity> findTokenByTokenAndValidTrue(String refreshTokenValue);
}
