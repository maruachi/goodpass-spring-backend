package com.goodchalk.goodpass.dailypass.domain;

import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.exception.GoodPassSystemException;
import com.goodchalk.goodpass.infra.SignatureFileStore;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class SignatureLocalSignatureFileStore implements SignatureFileStore {
    private final static String FILE_STORE_NAME = "dailypasses";

    @Override
    public String upload(String DailyPassDirectoryName, String dailyPassFileName, InputStream inputStream) {
        String userDir = System.getProperty("user.dir");
        Path dailyPassDirectoryPath = Paths.get(userDir, FILE_STORE_NAME, DailyPassDirectoryName);
        if (!Files.exists(dailyPassDirectoryPath)) {
            try {
                Files.createDirectories(dailyPassDirectoryPath);
            } catch (IOException e) {
                throw new GoodPassSystemException(e);
            }
        }

        Path dailyPassFilePath = dailyPassDirectoryPath.resolve(dailyPassFileName);
        File dailyPassFile = dailyPassFilePath.toFile();
        try (FileOutputStream dailyPassOutputStream = new FileOutputStream(dailyPassFile);){
            copyFile(inputStream, dailyPassOutputStream);
            dailyPassOutputStream.flush();
            dailyPassOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dailyPassFilePath.toAbsolutePath().toString();
    }

    public static void copyFile(InputStream sourceStream, OutputStream destinationStream) throws IOException {
        byte[] buffer = new byte[8092];
        int length;
        while ((length = sourceStream.read(buffer)) > 0) {
            destinationStream.write(buffer, 0, length);
        }

    }
}
