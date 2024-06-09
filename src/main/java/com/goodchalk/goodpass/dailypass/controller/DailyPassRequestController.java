package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.climbinggym.service.ClimbingGymCheckService;
import com.goodchalk.goodpass.dailypass.controller.dto.DailyPassRequestDto;
import com.goodchalk.goodpass.dailypass.controller.dto.DailyPassResponseDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.service.DailyPassRequestService;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DailyPassRequestController {
    private final DailyPassRequestService dailyPassRequestService;
    private final ClimbingGymCheckService climbingGymCheckService;

    @RequestMapping(value = "/dailypass/climbinggym/{id}", method = RequestMethod.POST)
    public DailyPassResponseDto dailyPassRequest(@PathVariable(value = "id") Long climbingGymId,
                                                 @RequestBody DailyPassRequestDto dailyPassRequestDto) {
        if (climbingGymCheckService.isNotExist(climbingGymId)) {
            throw new GoodPassBusinessException("등록되지 않은 클라이밍장입니다. climbingGymId = " + climbingGymId);
        }

        DailyPass dailyPass = dailyPassRequestDto.createDailyPass(climbingGymId);
        DailyPass savedDailyPass = dailyPassRequestService.save(dailyPass);
        return DailyPassResponseDto.from(savedDailyPass);
    }
}
