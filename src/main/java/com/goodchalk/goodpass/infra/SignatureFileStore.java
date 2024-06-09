package com.goodchalk.goodpass.infra;

import java.io.InputStream;

public interface SignatureFileStore {
    String upload(String dailyPassDirectoryName, String signatureFileName, InputStream inputStream);
}
