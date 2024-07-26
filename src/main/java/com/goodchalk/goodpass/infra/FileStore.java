package com.goodchalk.goodpass.infra;

import java.io.InputStream;

public interface FileStore {
    String upload(String directoryName, String fileName, InputStream inputStream);
}
