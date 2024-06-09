package com.goodchalk.goodpass.dailypass.domain;

import org.springframework.stereotype.Component;

@Component
public class DailyPassFileNameGenerator {
    public String generate(Long dailyPassId) {
        return dailyPassId.toString();
    }
}
