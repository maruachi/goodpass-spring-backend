package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymFindRegisteredResponseDto;
import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymRegisterRequestDto;
import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymRegisterResponseDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymRegisterService;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClimbingGymFindRegisteredController {
    private final ClimbingGymValidateService climbingGymValidateService;
    @RequestMapping(value = "/climbinggym/register/{climbingGymId}", method = RequestMethod.GET)
    public ClimbingGymFindRegisteredResponseDto findRegistered(@PathVariable Long climbingGymId) {
        System.out.println("hello");
        boolean validated = climbingGymValidateService.isValidated(climbingGymId);
        return ClimbingGymFindRegisteredResponseDto.of(validated);
    }
}
