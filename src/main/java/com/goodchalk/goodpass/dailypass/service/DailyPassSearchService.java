package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSearchService {
    private final DailyPassRepository dailyPassRepository;
    public DailyPass search(Long dailyPassId) {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(dailyPassId);
        if (dailyPassOptional.isEmpty()) {
            throw new GoodPassBusinessException("존재하지 않는 dailyPass 입니다. dailyPassId = " + dailyPassId);
        }
        return dailyPassOptional.get();
    }
}
