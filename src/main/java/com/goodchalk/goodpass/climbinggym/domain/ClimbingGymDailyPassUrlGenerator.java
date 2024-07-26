package com.goodchalk.goodpass.climbinggym.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class ClimbingGymDailyPassUrlGenerator {
    private final Environment environment;
    public String generate(Long climbingGymId) {
        String host = "localhost";
        String port = environment.getProperty("server.port");
        return MessageFormat.format("http://{0}:{1}/dailypass/climbinggym/{2}", host, port, climbingGymId);
    }
}
