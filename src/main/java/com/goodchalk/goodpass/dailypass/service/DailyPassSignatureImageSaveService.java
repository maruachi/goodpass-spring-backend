package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPassFileNameGenerator;
import com.goodchalk.goodpass.dailypass.domain.SignatureLocalFileStore;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import com.goodchalk.goodpass.infra.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class DailyPassSignatureImageSaveService {
    private final SignatureLocalFileStore fileStore;
    private final DailyPassFileNameGenerator dailyPassFileNameGenerator;
    public String save(Long climbingGymId, Long dailyPassId, MultipartFile signatureImageFile) {
        String dailyPassFileName = dailyPassFileNameGenerator.generate(dailyPassId);
        String dailyPassDirectoryName = climbingGymId.toString();
        InputStream signatureImageInputStream = getInputStreamFrom(signatureImageFile);
        return fileStore.upload(dailyPassDirectoryName, dailyPassFileName, signatureImageInputStream);
    }

    private static InputStream getInputStreamFrom(MultipartFile signatureImageFile) {
        try {
            return signatureImageFile.getInputStream();
        } catch (IOException e) {
            throw new GoodPassSystemException(e);
        }
    }
}
