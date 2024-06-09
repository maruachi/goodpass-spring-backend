package com.goodchalk.goodpass.dailypass.controller.dto;

import com.goodchalk.goodpass.dailypass.domain.Contract;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DailyPassRequestDto {
    private String guestName;
    private String contact;
    private Contract dailyUseContract;
    private Contract privacyContract;

    public DailyPass createDailyPass(Long climbingGymId) {
        return DailyPass.builder()
                .climbingGymId(climbingGymId)
                .guestName(guestName)
                .contact(contact)
                .dailyUseContract(dailyUseContract)
                .privacyContract(privacyContract)
                .build();
    }
}
