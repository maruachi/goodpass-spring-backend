package com.goodchalk.goodpass.admin.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private LocalDateTime createDateTime;

    public void setAdminRoleToManager() {
        this.adminRole = AdminRole.MANAGER;
    }

}

