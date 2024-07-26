package com.goodchalk.goodpass.infra;

import com.goodchalk.goodpass.exception.GoodPassSystemException;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
public class LocalFileStore implements FileStore {
    private final String fileStorePath;

    @Override
    public String upload(String directoryName, String fileName, InputStream inputStream) {
        String userDir = System.getProperty("user.dir");
        Path dailyPassDirectoryPath = Paths.get(userDir, fileStorePath, directoryName);
        if (!Files.exists(dailyPassDirectoryPath)) {
            try {
                Files.createDirectories(dailyPassDirectoryPath);
            } catch (IOException e) {
                throw new GoodPassSystemException(e);
            }
        }

        Path targetFilePath = dailyPassDirectoryPath.resolve(fileName);
        File targetFile = targetFilePath.toFile();
        try (FileOutputStream dailyPassOutputStream = new FileOutputStream(targetFile);){
            copyFile(inputStream, dailyPassOutputStream);
            dailyPassOutputStream.flush();
            dailyPassOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = "http://localhost";
        String port = "8081";
        String action = "/" + Paths.get(userDir).relativize(targetFilePath).toString();
        return url + ":" + port + action;
    }

    public String upload(String fileName, InputStream inputStream) {
        return upload("", fileName, inputStream);
    }

    public static void copyFile(InputStream sourceStream, OutputStream destinationStream) throws IOException {
        byte[] buffer = new byte[8092];
        int length;
        while ((length = sourceStream.read(buffer)) > 0) {
            destinationStream.write(buffer, 0, length);
        }
    }
}
