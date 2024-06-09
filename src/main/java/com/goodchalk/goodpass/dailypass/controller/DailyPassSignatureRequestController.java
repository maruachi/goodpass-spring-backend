package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.DailyPassSignatureResponseDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassCheckService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSignatureSaveService;
import com.goodchalk.goodpass.dailypass.service.DailyPassSignatureUpdateService;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DailyPassSignatureRequestController {
    private final DailyPassSignatureSaveService dailyPassSignatureSaveService;
    @RequestMapping(value = "/dailypass/{id}/signature", method = RequestMethod.POST)
    public DailyPassSignatureResponseDto dailyPassSignatureRequest(@PathVariable(value = "id") Long dailyPassId,
                                                                   @RequestParam("signatureImageFile") MultipartFile signatureImageFile) {
        DailyPass dailyPass = dailyPassSignatureSaveService.save(dailyPassId, signatureImageFile);
        return DailyPassSignatureResponseDto.from(dailyPass);
    }
}
