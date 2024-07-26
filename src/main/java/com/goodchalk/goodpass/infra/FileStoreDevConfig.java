package com.goodchalk.goodpass.infra;

import com.goodchalk.goodpass.climbinggym.domain.ClimingGymLogoLocalFileStore;
import com.goodchalk.goodpass.climbinggym.domain.ClimingGymPosterLocalFileStore;
import com.goodchalk.goodpass.dailypass.domain.SignatureLocalFileStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "local"})
public class FileStoreDevConfig {
    @Bean
    public ClimingGymLogoLocalFileStore climingGymLogoLocalFileStore() {
        return new ClimingGymLogoLocalFileStore("logo");
    }

    @Bean
    public ClimingGymPosterLocalFileStore climingGymPosterLocalFileStore() {
        return new ClimingGymPosterLocalFileStore("poster");
    }

    @Bean
    public SignatureLocalFileStore signatureLocalFileStore() {
        return new SignatureLocalFileStore("signature");
    }
}
