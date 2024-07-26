package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymLinkResourceFindDto;
import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymPosterSaveResponse;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.domain.LinkResourceType;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymLinkResourceFindService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymPosterSaveService;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class ClimbingGymPosterSaveController {
    private final ClimbingGymPosterSaveService climbingGymPosterSaveService;

    @RequestMapping(value = "/climbinggym/{climbingGymId}/poster/image", method = RequestMethod.POST)
    @PreAuthorize("#climbingGymId == principal.adminRoleValue")
    public ClimbingGymPosterSaveResponse saveImage(@PathVariable Long climbingGymId, @RequestParam MultipartFile posterImageFile) {
        InputStream posterImageInputStream = toInputStream(posterImageFile);
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymPosterSaveService.save(climbingGymId, posterImageInputStream);
        return ClimbingGymPosterSaveResponse.from(climbingGymLinkResource);
    }

    private static InputStream toInputStream(MultipartFile posterImageFile) {
        try {
            return posterImageFile.getInputStream();
        } catch (IOException e) {
            throw new GoodPassBusinessException("PosterImageFile을 inputStream으로 변환할 수 없습니다.");
        }
    }
}
