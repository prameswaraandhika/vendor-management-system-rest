package org.prameswaradev.vendormanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VendorManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendorManagementSystemApplication.class, args);
    }

}
