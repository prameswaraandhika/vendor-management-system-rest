package org.prameswaradev.vendormanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_token")
@Entity
public class TokenEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    private String id;

    private String username;

    @Column(nullable = false, unique = true, length = 2000)
    private String token;

    private Instant expiryDate;

    private boolean valid;
}
