package org.prameswaradev.vendormanagementsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @NotNull(message = "Vendor name is required")
    @NotBlank(message = "Vendor name cannot be blank")
    @Schema(description = "Name of the vendor", example = "PT Sinergi Informatika Semen Indonesia")
    private String name;

    @NotNull(message = "Vendor address is required")
    @NotBlank(message = "Vendor address cannot be blank")
    @Length(message = "Vendor address must be between 3 and 255 characters", min = 3, max = 255)
    @Schema(description = "Address of the vendor", example = "Graha Aktiva, Jl. H. R. Rasuna Said No.Kav 3 lantai 11, Kota Jakarta Selatan")
    private String address;

    @NotNull(message = "Vendor email is required")
    @NotBlank(message = "Vendor email cannot be blank")
    @Schema(description = "Email of the vendor", example = "ptsisi@sisi.sig.id")
    private String email;
}
