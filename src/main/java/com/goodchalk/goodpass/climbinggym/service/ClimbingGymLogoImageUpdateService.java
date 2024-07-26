package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimingGymLogoLocalFileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ClimbingGymLogoImageUpdateService {
    private final ClimingGymLogoLocalFileStore climbingGymLogoLocalFileStore;

    public String update(Long climbingGymId, InputStream logoImageInputStream) {
        String fileName = climbingGymId.toString();
        return climbingGymLogoLocalFileStore.upload(fileName, logoImageInputStream);
    }
}
