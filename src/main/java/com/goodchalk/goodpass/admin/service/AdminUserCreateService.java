package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.form.AdminUserJoinForm;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.admin.domain.AdminUserRepository;
import com.goodchalk.goodpass.infra.RandomPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserCreateService {
    private final PasswordEncoder passwordEncoder;
    private final RandomPasswordGenerator randomPasswordGenerator;
    private final AdminUserRepository adminUserRepository;
    public AdminUser createAdminUser(AdminUserCreator adminUserCreator) {
        AdminUser adminUser = adminUserCreator.toAdminUser();

        return adminUserRepository.save(adminUser);
    }
}
