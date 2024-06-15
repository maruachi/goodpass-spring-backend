package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.infra.RandomPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserJoinService {
    private final AdminManagerCreateService adminManagerCreateService;
    private final AdminUserJoinMailService adminUserJoinMailService;
    private final RandomPasswordGenerator randomPasswordGenerator;

    @Async
    public void join(AdminUser adminUser) {
        String randomPassword = randomPasswordGenerator.generatePassword();
        adminUserJoinMailService.send(adminUser, randomPassword);
        adminManagerCreateService.create(adminUser, randomPassword);
    }
}
