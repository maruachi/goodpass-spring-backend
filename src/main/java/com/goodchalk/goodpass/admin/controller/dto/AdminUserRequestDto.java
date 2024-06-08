package com.goodchalk.goodpass.admin.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserRequestDto {
    private String climbingGymName;
    private String climbingGymOwner;
    private String contact;
    private String email;
}
