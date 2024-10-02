package org.prameswaradev.vendormanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.RoleDto;
import org.prameswaradev.vendormanagementsystem.entity.RoleEntity;
import org.prameswaradev.vendormanagementsystem.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleDto createRole(RoleDto roleDto) {
        return new RoleDto(roleRepository.save(RoleEntity.builder().name(roleDto.getName()).build()).getName());
    }
}
