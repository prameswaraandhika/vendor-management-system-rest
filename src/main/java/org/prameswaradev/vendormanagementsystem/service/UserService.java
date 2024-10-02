package org.prameswaradev.vendormanagementsystem.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.UserDto;
import org.prameswaradev.vendormanagementsystem.entity.RoleEntity;
import org.prameswaradev.vendormanagementsystem.entity.UserEntity;
import org.prameswaradev.vendormanagementsystem.exception.NotFoundException;
import org.prameswaradev.vendormanagementsystem.mapper.UserEntityMapper;
import org.prameswaradev.vendormanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getByUsername(String username) {
        var user = userRepository.findByUsernameAndIsEnabledTrue(username);
        if (user.isEmpty()) {
            throw new NotFoundException("User " + user + " not found!");
        }
        return user.get();
    }

    public UserDto getDtoByUsername(String username) {
        var user = userRepository.findByUsernameAndIsEnabledTrue(username);
        if (user.isEmpty()) {
            throw new NotFoundException("User " + user + " not found!");
        }
        return UserEntityMapper.mapToUserDto(user.get());
    }

    public void createUser(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .name(userDto.getName())
                .birthDate(userDto.getBirthDate())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .isEnabled(true)
                .roles(
                        userDto.getRoles().stream()
                                .map(roleDto -> RoleEntity.builder()
                                        .name(roleDto.getName())
                                        .build())
                                .collect(Collectors.toSet())
                )
                .build();

        userRepository.save(userEntity);
    }

}
