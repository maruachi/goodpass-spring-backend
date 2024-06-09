package com.goodchalk.goodpass.dailypass.controller.dto;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DailyPassResponseDto {
    private Long dailyPassId;
    private Long climbingGymId;
    public static DailyPassResponseDto from(DailyPass dailyPass) {
        return DailyPassResponseDto.builder()
                .dailyPassId(dailyPass.getId())
                .climbingGymId(dailyPass.getClimbingGymId())
                .build();
    }
}
