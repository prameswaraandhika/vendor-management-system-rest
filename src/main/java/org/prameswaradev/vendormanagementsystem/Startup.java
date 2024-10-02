package org.prameswaradev.vendormanagementsystem;

import lombok.RequiredArgsConstructor;
import org.prameswaradev.vendormanagementsystem.dto.RoleDto;
import org.prameswaradev.vendormanagementsystem.dto.UserDto;
import org.prameswaradev.vendormanagementsystem.service.RoleService;
import org.prameswaradev.vendormanagementsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Startup implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        createDummyData();
    }

    private void createDummyData() {
        // Creating Roles
        RoleDto adminRole = new RoleDto();
        adminRole.setName("ADMIN");
        adminRole = roleService.createRole(adminRole);

        RoleDto userRole = new RoleDto();
        userRole.setName("USER");
        userRole = roleService.createRole(userRole);

        RoleDto modRole = new RoleDto();
        modRole.setName("MODERATOR");
        modRole = roleService.createRole(modRole);

        // Creating Users with BCrypt encoded passwords
        UserDto admin = new UserDto();
        admin.setName("Budi");
        admin.setUsername("budi@example.com");
        admin.setPassword(passwordEncoder.encode("password123"));  // BCrypt encoding
        admin.setRoles(Set.of(adminRole, modRole));  // Assigning ADMIN and USER roles
        userService.createUser(admin);

        UserDto user1 = new UserDto();
        user1.setName("Siti");
        user1.setUsername("siti@example.com");
        user1.setPassword(passwordEncoder.encode("password123"));
        user1.setRoles(Set.of(userRole, adminRole));  // Assigning USER role
        userService.createUser(user1);

        UserDto user2 = new UserDto();
        user2.setName("Agus");
        user2.setUsername("agus@example.com");
        user2.setPassword(passwordEncoder.encode("password123"));
        user2.setRoles(Set.of(userRole));  // Assigning USER role
        userService.createUser(user2);

        // Additional example user for MODERATOR role
        UserDto mod = new UserDto();
        mod.setName("Mod");
        mod.setUsername("mod@example.com");
        mod.setPassword(passwordEncoder.encode("password123"));
        mod.setRoles(Set.of(modRole));
        userService.createUser(mod);
    }
}