package com.goodchalk.goodpass.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@RequiredArgsConstructor
public class RandomPasswordGenerator {
    private final String availableCharacters;
    private final int passwordLength;
    private final Random random;

    public String generatePassword() {
        StringBuilder password = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(availableCharacters.length());
            password.append(availableCharacters.charAt(index));
        }
        return password.toString();
    }
}
