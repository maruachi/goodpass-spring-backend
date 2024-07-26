package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymPosterSaveResponse {
    private String posterLink;
    public static ClimbingGymPosterSaveResponse from(ClimbingGymLinkResource climbingGymLinkResource) {
        return ClimbingGymPosterSaveResponse.builder()
                .posterLink(climbingGymLinkResource.getLink())
                .build();
    }
}
