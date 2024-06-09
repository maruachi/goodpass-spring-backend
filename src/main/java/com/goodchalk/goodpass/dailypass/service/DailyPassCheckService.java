package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassCheckService {
    private final DailyPassRepository dailyPassRepository;

    public boolean isNotExist(Long dailyPassId) {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(dailyPassId);
        return dailyPassOptional.isEmpty();
    }
}
