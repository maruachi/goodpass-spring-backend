package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.ClimbingGym;
import com.goodchalk.goodpass.climbinggym.domain.ClimbingGymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClimbingGymCheckService {
    private final ClimbingGymRepository climbingGymRepository;

    public boolean isExist(Long climbingGymId) {
        Optional<ClimbingGym> climbingGym = climbingGymRepository.findById(climbingGymId);
        return climbingGym.isPresent();
    }

    public boolean isNotExist(Long climbingGymId) {
        return !isExist(climbingGymId);
    }
}
