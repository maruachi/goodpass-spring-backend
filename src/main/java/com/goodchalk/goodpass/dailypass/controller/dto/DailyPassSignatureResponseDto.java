package com.goodchalk.goodpass.dailypass.controller.dto;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DailyPassSignatureResponseDto {
    private Long dailyPassId;
    public static DailyPassSignatureResponseDto from(DailyPass dailyPass) {
        return DailyPassSignatureResponseDto.builder()
                .dailyPassId(dailyPass.getId())
                .build();
    }
}
