package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserJoinDto;
import com.goodchalk.goodpass.admin.service.AdminUserJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AdminUserJoinController {
    private final AdminUserJoinService adminUserJoinService;
    @GetMapping("/admin/join")
    public String getRequestAdminPage() {
        return "redirect:/admin-user-join.html";
    }

    @ResponseBody
    @PostMapping("/admin/join")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<String> requestAdminUser(@RequestBody AdminUserJoinDto adminUserJoinDto) {
        adminUserJoinService.join(adminUserJoinDto);

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}