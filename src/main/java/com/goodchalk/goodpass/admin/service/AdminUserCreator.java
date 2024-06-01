package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.form.AdminUserJoinForm;
import com.goodchalk.goodpass.admin.domain.AdminRole;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AdminUserCreator {
    private final AdminUserJoinForm adminUserJoinForm;
    private final String password;

    public AdminUser toAdminUser() {
        return AdminUser.builder()
                .username(adminUserJoinForm.getUsername())
                .password(password)
                .name(adminUserJoinForm.getName())
                .contact(adminUserJoinForm.getContact())
                .emailAddress(adminUserJoinForm.getEmailAddress())
                .adminRole(AdminRole.MANAGER)
                .createDateTime(LocalDateTime.now())
                .build();
    }
}
