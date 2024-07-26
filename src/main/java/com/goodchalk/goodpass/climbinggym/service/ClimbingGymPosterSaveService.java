package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterSaveService {
    private final ClimbingGymValidateService climbingGymValidateService;
    private final ClimbingGymPosterImageUpdateService climbingGymPosterImageUpdateService;
    private final ClimbingGymPosterLinkUpdateService climbingGymPosterLinkUpdateService;
    public ClimbingGymLinkResource save(Long climbingGymId, InputStream posterImageInputStream) {
        climbingGymValidateService.validate(climbingGymId);
        String posterLink = climbingGymPosterImageUpdateService.update(climbingGymId, posterImageInputStream);
        return climbingGymPosterLinkUpdateService.update(climbingGymId, posterLink);
    }
}
