package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.infra.LocalFileStore;

public class ClimingGymPosterLocalFileStore extends LocalFileStore {
    public ClimingGymPosterLocalFileStore(String fileStorePath) {
        super(fileStorePath);
    }
}
