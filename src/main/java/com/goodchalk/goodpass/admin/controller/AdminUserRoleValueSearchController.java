package com.goodchalk.goodpass.admin.controller;

import com.goodchalk.goodpass.admin.controller.dto.AdminUserRoleValueSearchResponseDto;
import com.goodchalk.goodpass.jwt.AdminUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminUserRoleValueSearchController {

    @RequestMapping(value = "/admin/manager/climbinggymid", method = RequestMethod.GET)
    @PreAuthorize("hasRole('MANAGER')")
    public AdminUserRoleValueSearchResponseDto authenticate(@AuthenticationPrincipal AdminUserDetails adminUserDetails) {
        return AdminUserRoleValueSearchResponseDto.of(adminUserDetails.getAdminRoleValue());
    }
}
