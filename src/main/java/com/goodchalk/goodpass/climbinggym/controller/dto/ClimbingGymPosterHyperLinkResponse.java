package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymPosterHyperLinkResponse {
    private String hyperLink;

    public static ClimbingGymPosterHyperLinkResponse from(ClimbingGymLinkResource climbingGymLinkResource) {
        return ClimbingGymPosterHyperLinkResponse.builder()
                .hyperLink(climbingGymLinkResource.getLink())
                .build();
    }
}
