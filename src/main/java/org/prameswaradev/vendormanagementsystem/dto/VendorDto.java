package org.prameswaradev.vendormanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorDto {

    private String id;

    @NotNull(message = "Vendor name is required")
    @NotBlank(message = "Vendor name cannot be blank ")
    private String name;

    @NotNull(message = "Vendor address is required")
    @NotBlank(message = "Vendor address cannot be blank ")
    @Length(message = "Vendor address min 3 char and max 12 char", min = 3, max = 255)
    private String address;

    @NotNull(message = "Vendor email is required")
    @NotBlank(message = "Vendor email cannot be blank ")
    private String email;
}
