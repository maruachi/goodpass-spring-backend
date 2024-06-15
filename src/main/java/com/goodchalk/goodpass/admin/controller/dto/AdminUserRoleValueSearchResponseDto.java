package com.goodchalk.goodpass.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AdminUserRoleValueSearchResponseDto {
    private Long climbingGymId;
    public static AdminUserRoleValueSearchResponseDto of(Long climbingGymId) {
        return AdminUserRoleValueSearchResponseDto.builder().climbingGymId(climbingGymId).build();
    }
}
