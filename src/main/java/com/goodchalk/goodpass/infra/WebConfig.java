package com.goodchalk.goodpass.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "file:uploads/" 경로의 파일을 "/uploads/**" 경로로 접근 가능하도록 설정
        registry.addResourceHandler("/dailypasses/**")
                .addResourceLocations("file:dailypasses/");
    }
}
