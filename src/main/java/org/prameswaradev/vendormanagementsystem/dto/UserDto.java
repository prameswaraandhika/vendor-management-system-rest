package org.prameswaradev.vendormanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Size(max = 20, message = "Name should not more than 6 caracters")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;

    @Size(max = 20, message = "username should not more than 6 caracters")
    @NotNull(message = "username is required")
    @NotBlank(message = "username cannot be blank ")
    private String username;

    @Length(min = 5, max = 32, message = "Email should not more than 6 caracters")
    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank ")
    private String password;

    private Set<RoleDto> roles = new HashSet<>();
}
