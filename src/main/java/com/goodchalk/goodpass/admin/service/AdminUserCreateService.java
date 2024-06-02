package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.admin.domain.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserCreateService {
    private final AdminUserRepository adminUserRepository;
    public AdminUser createAdminUser(AdminUserCreator adminUserCreator) {
        AdminUser adminUser = adminUserCreator.toAdminUser();
        adminUser.setAdminRoleToManager();
        return adminUserRepository.save(adminUser);
    }
}
