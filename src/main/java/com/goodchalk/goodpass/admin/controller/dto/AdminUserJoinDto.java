package com.goodchalk.goodpass.admin.controller.dto;

import com.goodchalk.goodpass.admin.domain.AdminUser;
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
    private Long climbingGymId;

    public AdminUser toAdminUser() {
        return AdminUser.builder()
                .username(username)
                .name(name)
                .contact(contact)
                .emailAddress(emailAddress)
                .adminRoleValue(climbingGymId)
                .build();
    }
}
