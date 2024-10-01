package org.prameswaradev.vendormanagementsystem.repository;

import org.prameswaradev.vendormanagementsystem.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, String> {
}
