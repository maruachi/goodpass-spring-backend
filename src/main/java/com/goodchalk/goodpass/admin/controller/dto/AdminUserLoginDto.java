package com.goodchalk.goodpass.admin.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AdminUserLoginDto {
    @NotBlank(message = "")
    @Size(min=3, max=20)
    private String username;
    @NotBlank(message = "")
    @Size(min=4, max=15)
    private String password;
}
