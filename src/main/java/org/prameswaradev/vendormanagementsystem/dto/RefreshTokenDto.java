package org.prameswaradev.vendormanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RefreshTokenDto {
    @NotNull(message = "Refresh token is required")
    @NotBlank(message = "Refresh token cannot be blank")
    private String refreshToken;
}
