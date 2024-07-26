package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymLinkResourceFindDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymLinkResourceFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClimbingGymLinkResourceFindController {
    private final ClimbingGymLinkResourceFindService climbingGymLinkResourceFindService;

    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/image", method = RequestMethod.GET)
    public ClimbingGymLinkResourceFindDto findPoster(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceFindService
                .find(climbingGymId, LinkResourceType.POSTER_IMAGE);
        return ClimbingGymLinkResourceFindDto.from(climbingGymLinkResource);
    }

    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/hyperlink", method = RequestMethod.GET)
    public ClimbingGymLinkResourceFindDto findHyperLink(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceFindService
                .find(climbingGymId, LinkResourceType.POSTER_HYPERLINK);
        return ClimbingGymLinkResourceFindDto.from(climbingGymLinkResource);
    }

    @RequestMapping(value = "/climbinggym/{climbingGymId}/logo", method = RequestMethod.GET)
    public ClimbingGymLinkResourceFindDto findLogo(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceFindService
                .find(climbingGymId, LinkResourceType.CLIMBING_GYM_LOGO);
        return ClimbingGymLinkResourceFindDto.from(climbingGymLinkResource);
    }

    @RequestMapping(value = "/climbinggym/{climbingGymId}/qr", method = RequestMethod.GET)
    @PreAuthorize("#climbingGymId == principal.adminRoleValue")
    public ClimbingGymLinkResourceFindDto findQr(@PathVariable Long climbingGymId) {
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceFindService
                .find(climbingGymId, LinkResourceType.DAILY_PASS_QR);
        return ClimbingGymLinkResourceFindDto.from(climbingGymLinkResource);
    }
}
