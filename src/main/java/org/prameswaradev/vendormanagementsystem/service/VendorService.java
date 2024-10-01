package org.prameswaradev.vendormanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.VendorDto;
import org.prameswaradev.vendormanagementsystem.entity.VendorEntity;
import org.prameswaradev.vendormanagementsystem.mapper.VendorEntityMapper;
import org.prameswaradev.vendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public List<VendorDto> getAllVendors() {
        List<VendorEntity> vendors = vendorRepository.findAll();
        return vendors.stream().map((VendorEntityMapper::mapToVendorDto)).toList();
    }
}
