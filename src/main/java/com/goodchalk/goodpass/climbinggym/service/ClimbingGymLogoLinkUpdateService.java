package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResourceRepository;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymLogoLinkUpdateService {
    private final ClimbingGymLinkResourceRepository climbingGymLinkResourceRepository;
    public ClimbingGymLinkResource update(Long climbingGymId, String logoLink) {
        Optional<ClimbingGymLinkResource> climbingGymLinkResourceOptional = climbingGymLinkResourceRepository
                .findByClimbingGymIdAndLinkResourceType(climbingGymId, LinkResourceType.CLIMBING_GYM_LOGO);
        if (climbingGymLinkResourceOptional.isEmpty()) {
            ClimbingGymLinkResource climbingGymLinkResource = ClimbingGymLinkResource.builder()
                    .climbingGymId(climbingGymId)
                    .linkResourceType(LinkResourceType.CLIMBING_GYM_LOGO)
                    .link(logoLink)
                    .build();
            return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
        }

        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceOptional.get();
        climbingGymLinkResource.setLink(logoLink);
        return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
    }
}
