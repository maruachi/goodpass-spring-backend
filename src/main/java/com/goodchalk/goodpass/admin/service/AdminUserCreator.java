package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserJoinDto;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AdminUserCreator {
    private final AdminUserJoinDto adminUserJoinDto;
    private final String password;

    public AdminUser toAdminUser() {
        return AdminUser.builder()
                .username(adminUserJoinDto.getUsername())
                .password(password)
                .name(adminUserJoinDto.getName())
                .contact(adminUserJoinDto.getContact())
                .emailAddress(adminUserJoinDto.getEmailAddress())
                .createDateTime(LocalDateTime.now())
                .build();
    }
}
