package org.prameswaradev.vendormanagementsystem.repository;

import org.prameswaradev.vendormanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


    Optional<UserEntity>  findByUsernameAndIsEnabledTrue(String username);
}
