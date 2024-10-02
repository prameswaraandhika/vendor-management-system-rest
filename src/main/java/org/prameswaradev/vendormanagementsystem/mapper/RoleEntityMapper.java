package org.prameswaradev.vendormanagementsystem.mapper;

import org.prameswaradev.vendormanagementsystem.dto.RoleDto;
import org.prameswaradev.vendormanagementsystem.entity.RoleEntity;

public class RoleEntityMapper {
    public static RoleDto mapToRoleDto(RoleEntity role) {
        return new RoleDto(role.getName());
    }
}
