package com.goodchalk.goodpass.admin.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserRequestForm {
    private String climbingGymName;
    private String climbingGymOwner;
    private String contact;
    private String email;
}
