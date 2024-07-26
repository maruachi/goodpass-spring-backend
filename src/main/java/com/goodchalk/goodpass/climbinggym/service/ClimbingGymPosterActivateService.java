package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResourceRepository;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import com.goodchalk.goodpass.climbinggym.domain.ResourceStatus;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterActivateService {
    private final ClimbingGymValidateService climbingGymValidateService;
    private final ClimbingGymLinkResourceRepository climbingGymLinkResourceRepository;
    public ClimbingGymLinkResource activate(Long climbingGymId, ResourceStatus resourceStatus) {
        climbingGymValidateService.validate(climbingGymId);
        Optional<ClimbingGymLinkResource> climbingGymLinkResourceOptional = climbingGymLinkResourceRepository
                .findByClimbingGymIdAndLinkResourceType(climbingGymId, LinkResourceType.POSTER_HYPERLINK);
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceOptional
                .orElseThrow(()->new GoodPassBusinessException("활성화 할 링크가 존재하지 않습니다. climbingGymId = " + climbingGymId));
        climbingGymLinkResource.setResourceType(resourceStatus);
        return climbingGymLinkResource;
    }
}
