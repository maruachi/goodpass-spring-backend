package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymFindRegisteredResponseDto {
    @JsonProperty("isRegistered")
    private boolean isRegistered;
    public static ClimbingGymFindRegisteredResponseDto of(boolean validated) {
        return ClimbingGymFindRegisteredResponseDto.builder()
                .isRegistered(validated)
                .build();
    }
}
