package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymLogoSaveResponseDto {
    private String link;
    public static ClimbingGymLogoSaveResponseDto from(ClimbingGymLinkResource climbingGymLinkResource) {
        return ClimbingGymLogoSaveResponseDto.builder()
                .link(climbingGymLinkResource.getLink())
                .build();
    }
}
