package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymRegisterRequestDto {
    private String climbingGymName;
    private String address;
    private String instagramAccount;

    public ClimbingGym createClimbingGym() {
        return ClimbingGym.builder()
                .climbingGymName(climbingGymName)
                .address(address)
                .instagramAccount(instagramAccount)
                .build();
    }
}
