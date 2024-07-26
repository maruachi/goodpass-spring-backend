package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ResourceStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymPosterStatusResponseDto {
    private ResourceStatus resourceStatus;
    public static ClimbingGymPosterStatusResponseDto from(ClimbingGymLinkResource climbingGymLinkResource) {
        return ClimbingGymPosterStatusResponseDto.builder()
                .resourceStatus(climbingGymLinkResource.getResourceStatus())
                .build();
    }
}
