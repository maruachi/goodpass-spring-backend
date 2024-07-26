package com.goodchalk.goodpass.climbinggym.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClimbingGymLinkResourceRepository extends JpaRepository<ClimbingGymLinkResource, Long> {
    Optional<ClimbingGymLinkResource> findByClimbingGymIdAndLinkResourceType(Long climbingGymId, LinkResourceType linkResourceType);
}
