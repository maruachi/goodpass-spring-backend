package com.goodchalk.goodpass.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AdminUserLoginDto {
    private String username;
    private String password;
}
