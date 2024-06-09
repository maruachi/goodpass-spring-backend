package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import com.goodchalk.goodpass.dailypass.domain.SignatureStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSignatureUpdateService {
    private final DailyPassRepository dailyPassRepository;
    public DailyPass update(Long dailyPassId, String signatureLink) {
        Optional<DailyPass> dailyPassOptional = dailyPassRepository.findById(dailyPassId);
        DailyPass dailyPass = dailyPassOptional.get();
        dailyPass.setSignatureLink(signatureLink);
        dailyPass.updateSignatureStatus(SignatureStatus.SUBMIT);
        return dailyPassRepository.save(dailyPass);
    }
}
