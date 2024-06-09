package com.goodchalk.goodpass.admin.controller.dto;

import com.goodchalk.goodpass.admin.domain.AdminRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminUserLoginResponseDto {
    private String token;
    private String adminRole;
}
