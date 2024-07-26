package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResourceRepository;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterLinkUpdateService {
    private final ClimbingGymLinkResourceRepository climbingGymLinkResourceRepository;
    public ClimbingGymLinkResource update(Long climbingGymId, String posterLink) {
        Optional<ClimbingGymLinkResource> climbingGymLinkResourceOptional = climbingGymLinkResourceRepository
                .findByClimbingGymIdAndLinkResourceType(climbingGymId, LinkResourceType.POSTER_IMAGE);
        if (climbingGymLinkResourceOptional.isEmpty()) {
            ClimbingGymLinkResource climbingGymLinkResource = ClimbingGymLinkResource.builder()
                    .climbingGymId(climbingGymId)
                    .linkResourceType(LinkResourceType.POSTER_IMAGE)
                    .link(posterLink)
                    .build();
            return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
        }

        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLinkResourceOptional.get();
        climbingGymLinkResource.setLink(posterLink);
        return climbingGymLinkResourceRepository.save(climbingGymLinkResource);
    }
}
