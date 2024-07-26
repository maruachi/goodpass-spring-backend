package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResourceRepository;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymResourceLinkUpdateService {
    private final ClimbingGymLinkResourceRepository climbingGymLinkResourceRepository;
    public ClimbingGymLinkResource update(Long climbingGymId, String link, LinkResourceType linkResourceType) {
        Optional<ClimbingGymLinkResource> climbingGymLinkResourceOptional = climbingGymLinkResourceRepository
                .findByClimbingGymIdAndLinkResourceType(climbingGymId, LinkResourceType.POSTER_HYPERLINK);
        if (climbingGymLinkResourceOptional.isEmpty()) {
            ClimbingGymLinkResource climbingGymLinkResource = ClimbingGymLinkResource.builder()
                    .climbingGymId(climbingGymId)
                    .linkResourceType(linkResourceType)
                    .link(link)
                    .build();
            return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
        }

        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceOptional.get();
        climbingGymLinkResource.setLink(link);
        return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
    }
}
