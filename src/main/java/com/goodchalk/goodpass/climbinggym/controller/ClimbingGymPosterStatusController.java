package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymPosterStatusResponseDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ResourceStatus;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterActivateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClimbingGymPosterStatusController {
    private final ClimbingGymPosterActivateService climbingGymPosterActivateService;

    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/active")
    public ClimbingGymPosterStatusResponseDto activate(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymPosterActivateService.activate(climbingGymId, ResourceStatus.ACTIVE);
        return ClimbingGymPosterStatusResponseDto.from(climbingGymLinkResource);
    }
    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/inactive")
    public ClimbingGymPosterStatusResponseDto deactivate(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymPosterActivateService.activate(climbingGymId, ResourceStatus.INACTIVE);
        return ClimbingGymPosterStatusResponseDto.from(climbingGymLinkResource);
    }
}
