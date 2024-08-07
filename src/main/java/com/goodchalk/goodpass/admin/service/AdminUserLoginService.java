package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginDto;
import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginResponseDto;
import com.goodchalk.goodpass.admin.domain.AdminUser;
import com.goodchalk.goodpass.admin.domain.AdminUserRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.jwt.JWTProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUserLoginService {
    private final AdminUserRepository adminUserRepository;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public AdminUserLoginResponseDto login(AdminUserLoginDto adminUserLoginDto) {
        AdminUser adminUser = adminUserRepository.findByUsername(adminUserLoginDto.getUsername());
        if (adminUser == null) {
            throw new GoodPassBusinessException("유저를 찾을 수 없습니다. username = " + adminUserLoginDto.getUsername());
        }
        if (!passwordEncoder.matches(adminUserLoginDto.getPassword(), adminUser.getPassword())) {
            throw new GoodPassBusinessException("비밀번호가 잘못됐습니다. username = " + adminUserLoginDto.getUsername());
        }

        String adminRole = adminUser.getAdminRole().toString();
        String adminRoleValue = adminUser.getAdminRoleValue().toString();
        String token = jwtProvider.createJwt(adminUser.getUsername(), adminRole, adminRoleValue);

        return AdminUserLoginResponseDto.builder()
                .token(token)
                .adminRole(adminRole)
                .build();
    }
}
