package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymValidateService {
    private final ClimbingGymRepository climbingGymRepository;

    public void validate(Long climbingGymId) {
        Optional<ClimbingGym> climbingGym = climbingGymRepository.findById(climbingGymId);
        climbingGym.orElseThrow(() -> new GoodPassBusinessException("존재하지 않는 클라이밍장 id 입니다. climbingGymId = " + climbingGymId));
    }

    public boolean isValidated(Long climbingGymId) {
        Optional<ClimbingGym> climbingGym = climbingGymRepository.findById(climbingGymId);
        return climbingGym.isPresent();
    }
}
