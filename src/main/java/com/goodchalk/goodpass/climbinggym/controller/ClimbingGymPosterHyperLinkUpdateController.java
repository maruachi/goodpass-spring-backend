package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymPosterHyperLinkRequest;
import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymPosterHyperLinkResponse;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterHyperLinkUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClimbingGymPosterHyperLinkUpdateController {
    private final ClimbingGymPosterHyperLinkUpdateService climbingGymPosterHyperLinkUpdateService;

    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/hyperlink", method = RequestMethod.POST)
    @PreAuthorize("#climbingGymId == principal.adminRoleValue")
    public ClimbingGymPosterHyperLinkResponse saveHyperLink(@PathVariable Long climbingGymId,
                                                            @RequestBody ClimbingGymPosterHyperLinkRequest climbingGymPosterHyperLinkRequest) {
        String hyperLink = climbingGymPosterHyperLinkRequest.getHyperLink();
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymPosterHyperLinkUpdateService.update(climbingGymId, hyperLink);
        return ClimbingGymPosterHyperLinkResponse.from(climbingGymLinkResource);
    }
}
