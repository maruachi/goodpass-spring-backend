package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymCheckService;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPassSignatureSaveService {
    private final DailyPassCheckService dailyPassCheckService;
    private final ClimbingGymCheckService climbingGymCheckService;
    private final DailyPassSearchService dailyPassSearchService;
    private final DailyPassSignatureImageSaveService dailyPassSignatureImageSaveService;
    private final DailyPassSignatureUpdateService dailyPassSignatureUpdateService;
    public DailyPass save(Long dailyPassId, MultipartFile signatureImageFile) {
        if (dailyPassCheckService.isNotExist(dailyPassId)) {
            throw new GoodPassBusinessException("존재하지 않는 dailyPass 입니다. dailyPassId = " + dailyPassId);
        }

        DailyPass dailyPass = dailyPassSearchService.search(dailyPassId);
        Long climbingGymId = dailyPass.getClimbingGymId();

        if (climbingGymCheckService.isNotExist(climbingGymId)) {
            throw new GoodPassBusinessException("존재하지 않는 climbingGymId 입니다. climbingGymId = " + climbingGymId);
        }

        String signatureLink = dailyPassSignatureImageSaveService.save(climbingGymId, dailyPassId, signatureImageFile);
        return dailyPassSignatureUpdateService.update(dailyPassId, signatureLink);
    }
}
