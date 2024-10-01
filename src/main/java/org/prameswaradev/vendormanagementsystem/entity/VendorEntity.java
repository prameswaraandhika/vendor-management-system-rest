package org.prameswaradev.vendormanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_vendor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
@SQLDelete(sql = "UPDATE tbl_vendor SET is_deleted = 'true' WHERE id=?")
public class VendorEntity extends BaseEntity {
    @NotNull(message = "Vendor name is required")
    @NotBlank(message = "Vendor name cannot be blank ")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Vendor address is required")
    @NotBlank(message = "Vendor address cannot be blank ")
    @Column(nullable = false)
    @Length(message = "Vendor address min 3 char and max 12 char", min = 3, max = 255)
    private String address;

    @NotNull(message = "Vendor email is required")
    @NotBlank(message = "Vendor email cannot be blank ")
    @Column(nullable = false)
    private String email;

}
