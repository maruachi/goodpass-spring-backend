package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserRequestDto;
import com.goodchalk.goodpass.admin.service.AdminUserRequestMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class AdminUserRequestController {
    private final AdminUserRequestMailService adminUserRequestMailService;
    @GetMapping("/admin/request")
    public String getRequestAdminPage() {
        return "redirect:/admin-user-request.html";
    }

    @ResponseBody
    @PostMapping("/admin/request")
    public ResponseEntity<String> requestAdminUser(@RequestBody AdminUserRequestDto adminUserRequestDto) {
        adminUserRequestMailService.sendUserRequestMail(adminUserRequestDto);

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
