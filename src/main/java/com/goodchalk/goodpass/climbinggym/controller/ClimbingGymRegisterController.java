package com.goodchalk.goodpass.climbinggym.controller;

import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymRegisterRequestDto;
import com.goodchalk.goodpass.climbinggym.controller.dto.ClimbingGymRegisterResponseDto;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.service.ClimbingGymRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClimbingGymRegisterController {
    private final ClimbingGymRegisterService climbingGymRegisterService;
    @RequestMapping(value = "/climbinggym/register", method = RequestMethod.POST)
    @PreAuthorize("hasRole('MASTER')")
    public ClimbingGymRegisterResponseDto register(@RequestBody ClimbingGymRegisterRequestDto climbingGymRegisterRequestDto) {
        ClimbingGym climbingGym = climbingGymRegisterRequestDto.createClimbingGym();
        climbingGymRegisterService.register(climbingGym);
        return ClimbingGymRegisterResponseDto.from(climbingGym);
    }
}
