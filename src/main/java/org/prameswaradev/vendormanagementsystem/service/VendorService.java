package org.prameswaradev.vendormanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.VendorDto;
import org.prameswaradev.vendormanagementsystem.entity.VendorEntity;
import org.prameswaradev.vendormanagementsystem.exception.NotFoundException;
import org.prameswaradev.vendormanagementsystem.mapper.VendorEntityMapper;
import org.prameswaradev.vendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public List<VendorDto> getAllVendors() {
        var vendors = vendorRepository.findAll();
        return vendors.stream().map((VendorEntityMapper::mapToVendorDto)).toList();
    }

    public VendorDto getVendorById(String vendorId) {
        var vendor = vendorRepository.findById(vendorId)
                .orElseThrow(NotFoundException::new);
        return VendorEntityMapper.mapToVendorDto(vendor);
    }

    public VendorDto createVendor(VendorDto vendorDto) {
        var vendor = VendorEntityMapper.mapToVendorEntity(vendorDto);
        var savedVendor = vendorRepository.save(vendor);
        return VendorEntityMapper.mapToVendorDto(savedVendor);
    }

}
