package org.prameswaradev.vendormanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class RegisterDto {
    @Length(max = 6, message = "Name should not more than 6 caracters")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;

    @Length(max = 6, message = "Email should not more than 6 caracters")
    @NotNull(message = "Email address is required")
    @NotBlank(message = "Email address cannot be blank ")
    private String email;

    @Length(min = 5, max = 32, message = "Email should not more than 6 caracters")
    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank ")
    private String password;
}
