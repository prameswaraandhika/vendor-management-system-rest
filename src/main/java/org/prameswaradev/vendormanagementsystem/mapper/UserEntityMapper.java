package org.prameswaradev.vendormanagementsystem.mapper;

import org.prameswaradev.vendormanagementsystem.dto.UserDto;
import org.prameswaradev.vendormanagementsystem.entity.UserEntity;

import java.util.stream.Collectors;

public class UserEntityMapper {
    public static UserDto mapToUserDto(UserEntity user) {
        return UserDto.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .birthDate(user.getBirthDate())
                .roles(user.getRoles().stream()
                        .map(RoleEntityMapper::mapToRoleDto)
                        .collect(Collectors.toSet()))  // Ensure roles are collected as a Set
                .build();
    }

}
