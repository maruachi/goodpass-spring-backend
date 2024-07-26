package com.goodchalk.goodpass.climbinggym.domain;

import com.goodchalk.goodpass.infra.LocalFileStore;

public class ClimingGymLogoLocalFileStore extends LocalFileStore {

    public ClimingGymLogoLocalFileStore(String fileStorePath) {
        super(fileStorePath);
    }
}
