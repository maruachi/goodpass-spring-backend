package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResourceRepository;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymLinkResourceFindService {
    private final ClimbingGymLinkResourceRepository climbingGymLinkResourceRepository;
    public ClimbingGymLinkResource find(Long climbingGymId, LinkResourceType linkResourceType) {
        Optional<ClimbingGymLinkResource> climbingGymLinkResourceOptional = climbingGymLinkResourceRepository.findByClimbingGymIdAndLinkResourceType(climbingGymId, linkResourceType);
        return climbingGymLinkResourceOptional.orElseGet(() -> ClimbingGymLinkResource.builder()
                .climbingGymId(climbingGymId)
                .linkResourceType(linkResourceType)
                .link("")
                .build());

    }

}
