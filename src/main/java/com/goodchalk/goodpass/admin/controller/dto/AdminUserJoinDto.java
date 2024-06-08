package com.goodchalk.goodpass.admin.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserJoinDto {
    private String username;
    private String name;
    private String contact;
    private String emailAddress;
}
