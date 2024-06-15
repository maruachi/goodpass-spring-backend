package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.admin.domain.AdminUserRepository;
import com.goodchalk.goodpass.infra.RandomPasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminManagerCreateService {
    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;
    public AdminUser create(AdminUser adminUser, String password){
        adminUser.saveEncodedPassword(password, passwordEncoder);
        adminUser.setAdminRoleToManager();
        adminUser.setCreateDateTimeToNow();
        return adminUserRepository.save(adminUser);
    }
}
