package com.goodchalk.goodpass.admin.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String contact;
    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private AdminRole adminRole;
    private Long adminRoleValue;
    private LocalDateTime createDateTime;

    public void setAdminRoleToManager() {
        this.adminRole = AdminRole.MANAGER;
    }

    public void setCreateDateTimeToNow() {
        this.createDateTime = LocalDateTime.now();
    }

    public void saveEncodedPassword(String password, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

}

