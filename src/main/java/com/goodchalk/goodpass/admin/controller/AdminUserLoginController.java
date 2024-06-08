package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserLoginDto;
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
    public String AdminUserLogin(@RequestBody AdminUserLoginDto adminUserLoginDto, HttpServletResponse response) {
        AdminUserLoginDto adminUserLoginResult = null;
        try {
            adminUserLoginResult = adminUserLoginService.login(adminUserLoginDto);
        } catch (RuntimeException e) {
            e.printStackTrace();
            response.setStatus(401);
            return "로그인에 실패했습니다.";
        }

        String token = adminUserLoginResult.getToken();

        response.setStatus(200);
        response.addHeader("Authorization", "Bearer " + token);
        return "로그인에 성공했습니다.";
    }
}
