package com.goodchalk.goodpass.climbinggym.controller.dto;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClimbingGymLinkResourceFindDto {
    private String link;
    public static ClimbingGymLinkResourceFindDto from(ClimbingGymLinkResource climbingGymLinkResource) {
        return ClimbingGymLinkResourceFindDto.builder()
                .link(climbingGymLinkResource.getLink())
                .build();
    }
}
