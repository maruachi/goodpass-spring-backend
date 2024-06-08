package com.goodchalk.goodpass.admin.service;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginDto;
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

    public AdminUserLoginDto login(AdminUserLoginDto adminUserLoginDto) {
        AdminUser adminUser = adminUserRepository.findByUsername(adminUserLoginDto.getUsername());
        if (adminUser == null) {
            throw new GoodPassBusinessException("유저를 찾을 수 없습니다. uesrname = " + adminUserLoginDto.getUsername());
        }
        if (!passwordEncoder.matches(adminUserLoginDto.getPassword(), adminUser.getPassword())) {
            throw new GoodPassBusinessException("비밀번호가 잘못됐습니다. username = " + adminUserLoginDto.getUsername());
        }

        String token = jwtProvider.createJwt(adminUser.getUsername(), adminUser.getAdminRole().toString());

        adminUserLoginDto.setToken(token);
        //토큰 생성하여 전송
        return adminUserLoginDto;
    }
}
