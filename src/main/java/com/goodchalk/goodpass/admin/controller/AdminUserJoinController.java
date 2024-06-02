package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.form.AdminUserJoinForm;
import com.goodchalk.goodpass.admin.controller.form.AdminUserRequestForm;
import com.goodchalk.goodpass.admin.service.AdminUserJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AdminUserJoinController {
    private final AdminUserJoinService adminUserJoinService;
    @GetMapping("/admin-user/join")
    public String getRequestAdminPage() {
        return "redirect:/admin-user-join.html";
    }

    @ResponseBody
    @PostMapping("/admin-user/join")
    public ResponseEntity<String> requestAdminUser(@RequestBody AdminUserJoinForm adminUserJoinForm) {
        adminUserJoinService.join(adminUserJoinForm);

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}