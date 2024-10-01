package org.prameswaradev.vendormanagementsystem.mapper;

import org.prameswaradev.vendormanagementsystem.dto.VendorDto;
import org.prameswaradev.vendormanagementsystem.entity.VendorEntity;

public class VendorEntityMapper {
    public static VendorDto mapToVendorDto(VendorEntity vendor){
        return VendorDto.builder()
                .id(vendor.getId())
                .name(vendor.getName())
                .email(vendor.getEmail())
                .address(vendor.getAddress())
                .build();
    }
}
