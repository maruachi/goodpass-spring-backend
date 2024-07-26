package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.infra.LocalFileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class ClimbingGymPosterImageUpdateService {
    private final LocalFileStore climingGymPosterLocalFileStore = new LocalFileStore("poster");

    public String update(Long climbingGymId, InputStream posterImageInputStream) {
        String fileName = climbingGymId.toString();
        return climingGymPosterLocalFileStore.upload(fileName, posterImageInputStream);
    }
}
