package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ClimbingGymLogoSaveService {
    private final ClimbingGymValidateService climbingGymValidateService;
    private final ClimbingGymLogoImageUpdateService climbingGymLogoImageUpdateService;
    private final ClimbingGymLogoLinkUpdateService climbingGymLogoLinkUpdateService;
    public ClimbingGymLinkResource save(Long climbingGymId, InputStream posterImageInputStream) {
        climbingGymValidateService.validate(climbingGymId);
        String posterLink = climbingGymLogoImageUpdateService.update(climbingGymId, posterImageInputStream);
        return climbingGymLogoLinkUpdateService.update(climbingGymId, posterLink);
    }
}
