package org.prameswaradev.vendormanagementsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

    @Schema(description = "Email address of the user", example = "budi@example.com", required = true)
    @NotNull(message = "Email address is required")
    @NotBlank(message = "Email address cannot be blank")
    private String username;

    @Schema(description = "Password of the user", example = "password123", required = true)
    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
