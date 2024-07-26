package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymLogoSaveResponseDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymLinkResource;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymLogoSaveService;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class ClimbingGymLogoSaveController {
    private final ClimbingGymLogoSaveService climbingGymLogoSaveService;
    @RequestMapping(value = "/climbinggym/{climbingGymId}/logo", method = RequestMethod.POST)
    @PreAuthorize("#climbingGymId == principal.adminRoleValue")
    public ClimbingGymLogoSaveResponseDto saveImage(@PathVariable Long climbingGymId, @RequestParam MultipartFile logoImageFile) {
        InputStream logoImageInputStream = toInputStream(logoImageFile);
        ClimbingGymLinkResource climbingGymLinkResource = climbingGymLogoSaveService.save(climbingGymId, logoImageInputStream);
        return ClimbingGymLogoSaveResponseDto.from(climbingGymLinkResource);
    }

    private static InputStream toInputStream(MultipartFile posterImageFile) {
        try {
            return posterImageFile.getInputStream();
        } catch (IOException e) {
            throw new GoodPassBusinessException("PosterImageFile을 inputStream으로 변환할 수 없습니다.");
        }
    }
}
