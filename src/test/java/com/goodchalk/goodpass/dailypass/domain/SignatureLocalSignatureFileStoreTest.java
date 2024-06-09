package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.infra.SignatureFileStore;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class SignatureLocalSignatureFileStoreTest {
    private final SignatureFileStore signatureFileStore = new SignatureLocalSignatureFileStore();

    @Test
    void upload() {
        String signatureLink = signatureFileStore.upload("1", "1", new ByteArrayInputStream(new byte[1]));
        System.out.println(signatureLink);
    }
}