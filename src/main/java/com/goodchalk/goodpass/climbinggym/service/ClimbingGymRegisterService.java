package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimbingGymRegisterService {
    private final ClimbingGymRepository climbingGymRepository;
    public ClimbingGym register(ClimbingGym climbingGym) {
        climbingGym.recordRequestTime();
        return climbingGymRepository.save(climbingGym);
    }
}
