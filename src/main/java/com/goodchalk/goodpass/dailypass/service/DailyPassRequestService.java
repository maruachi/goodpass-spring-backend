package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyPassRequestService {
    private final DailyPassRepository dailyPassRepository;
    public DailyPass save(DailyPass dailyPass) {
        dailyPass.updateSignatureStatus(SignatureStatus.NOT_SUBMIT);
        return dailyPassRepository.save(dailyPass);
    }
}
