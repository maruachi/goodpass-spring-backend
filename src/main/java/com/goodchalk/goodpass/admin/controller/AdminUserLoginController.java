package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginDto;
import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginResponseDto;
import com.goodchalk.goodpass.admin.service.AdminUserLoginService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminUserLoginController {
    private final AdminUserLoginService adminUserLoginService;

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public AdminUserLoginResponseDto AdminUserLogin(@RequestBody AdminUserLoginDto adminUserLoginDto, HttpServletResponse response) {
        AdminUserLoginResponseDto adminUserLoginResponseDto = null;
        try {
            adminUserLoginResponseDto = adminUserLoginService.login(adminUserLoginDto);
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.setStatus(401);
            return adminUserLoginResponseDto;
        }

        String token = adminUserLoginResponseDto.getToken();

        response.setStatus(200);
        response.addHeader("Authorization", "Bearer " + token);
        return adminUserLoginResponseDto;
    }
}
