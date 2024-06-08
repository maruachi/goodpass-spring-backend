package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserJoinDto;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.infra.RandomPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserJoinService {
    private final RandomPasswordGenerator randomPasswordGenerator;
    private final PasswordEncoder passwordEncoder;
    private final AdminUserCreateService adminUserCreateService;
    private final AdminUserJoinMailService adminUserJoinMailService;

    public void join(AdminUserJoinDto adminUserJoinDto) {
        String randomPassword = randomPasswordGenerator.generatePassword();

        String encodePassword = passwordEncoder.encode(randomPassword);
        AdminUserCreator adminUserCreator = new AdminUserCreator(adminUserJoinDto, encodePassword);
        AdminUser adminUser = adminUserCreateService.createAdminUser(adminUserCreator);

        adminUserJoinMailService.send(adminUser, randomPassword);
    }
}
