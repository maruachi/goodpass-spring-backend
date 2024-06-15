package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ClimbingGymRegisterResponseDto {
    private Long climbingGymId;
    private String climbingGymName;
    private String address;
    private String instagramAccount;
    private LocalDateTime requestDateTime;
    public static ClimbingGymRegisterResponseDto from(ClimbingGym climbingGym) {
        return ClimbingGymRegisterResponseDto.builder()
                .climbingGymId(climbingGym.getId())
                .climbingGymName(climbingGym.getClimbingGymName())
                .address(climbingGym.getAddress())
                .instagramAccount(climbingGym.getInstagramAccount())
                .requestDateTime(climbingGym.getRequestDateTime())
                .build();
    }
}
