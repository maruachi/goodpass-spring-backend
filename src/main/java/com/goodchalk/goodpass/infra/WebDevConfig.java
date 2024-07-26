package com.goodchalk.goodpass.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile({"dev", "local"})
public class WebDevConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/dailypasses/**")
                .addResourceLocations("file:dailypasses/");
        registry.addResourceHandler("/poster/**")
                .addResourceLocations("file:poster/");
        registry.addResourceHandler("/logo/**")
                .addResourceLocations("file:logo/");
    }
}
