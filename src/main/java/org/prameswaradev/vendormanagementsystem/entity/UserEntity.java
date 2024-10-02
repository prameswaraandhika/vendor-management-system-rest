package org.prameswaradev.vendormanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
@SQLRestriction("is_deleted = false")
@SQLDelete(sql = "UPDATE tbl_user SET is_deleted = 'true' WHERE id=?")
public class UserEntity extends BaseEntity {
    @Length(max = 20, message = "Name should not more than 6 caracters")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;


    @Length(max = 20, message = "username should not more than 6 caracters")
    @NotNull(message = "username is required")
    @NotBlank(message = "username cannot be blank ")
    @Column(unique = true)
    private String username;


    @Length(min = 5, max = 120, message = "Email should not more than 6 caracters")
    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank ")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    private Set<RoleEntity> roles = new HashSet<>();

    @Column(columnDefinition = "boolean default true")
    private boolean isEnabled = true;
}
