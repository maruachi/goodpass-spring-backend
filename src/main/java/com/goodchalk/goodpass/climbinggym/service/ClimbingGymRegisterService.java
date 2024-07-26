package com.goodchalk.goodpass.climbinggym.service;

import com.goodchalk.goodpass.climbinggym.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClimbingGymRegisterService {
    private final ClimbingGymRepository climbingGymRepository;
    private final ClimbingGymDailyPassUrlGenerator climbingGymDailyPassUrlGenerator;
    private final ClimbingGymResourceLinkUpdateService climbingGymResourceLinkUpdateService;
    public ClimbingGym register(ClimbingGym climbingGym) {
        ClimbingGym savedClimbingGym = climbingGymRepository.save(climbingGym);
        Long climbingGymId = savedClimbingGym.getId();
        String qrUrl = climbingGymDailyPassUrlGenerator.generate(climbingGymId);
        climbingGymResourceLinkUpdateService.update(climbingGymId, qrUrl, LinkResourceType.DAILY_PASS_QR);
        return savedClimbingGym;
    }
}
