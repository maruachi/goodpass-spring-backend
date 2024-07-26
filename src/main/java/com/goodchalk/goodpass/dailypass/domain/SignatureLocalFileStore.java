package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.infra.LocalFileStore;

public class SignatureLocalFileStore extends LocalFileStore {

    public SignatureLocalFileStore(String fileStorePath) {
        super(fileStorePath);
    }
}
