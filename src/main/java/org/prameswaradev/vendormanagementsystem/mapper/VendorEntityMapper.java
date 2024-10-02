package org.prameswaradev.vendormanagementsystem.mapper;

import org.prameswaradev.vendormanagementsystem.dto.VendorDto;
import org.prameswaradev.vendormanagementsystem.entity.VendorEntity;

public class VendorEntityMapper {
    public static VendorDto mapToVendorDto(VendorEntity vendor) {
        return VendorDto.builder()
                .name(vendor.getName())
                .email(vendor.getEmail())
                .address(vendor.getAddress())
                .build();
    }

    public static VendorEntity mapToVendorEntity(VendorDto vendorDto) {
        return VendorEntity.builder()
                .name(vendorDto.getName())
                .email(vendorDto.getEmail())
                .address(vendorDto.getAddress())
                .build();
    }
}
