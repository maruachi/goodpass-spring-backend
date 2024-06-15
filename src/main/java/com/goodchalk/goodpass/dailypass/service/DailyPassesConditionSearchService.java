package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.DailyPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyPassesConditionSearchService {
    private final DailyPassRepository dailyPassRepository;

    public Page<DailyPass> searchByNoCondition(Long climbingGymId, Pageable pageable) {
        return dailyPassRepository.findByClimbingGymIdOrderByRequestDateTimeDesc(climbingGymId, pageable);
    }
    public Page<DailyPass> searchByName(Long climbingGymId, String guestName, Pageable pageable) {
        String guestNameWithWildCard = guestName + '%';
        return dailyPassRepository.findByClimbingGymIdAndGuestNameLikeOrderByGuestNameAscRequestDateTimeDesc(climbingGymId, guestNameWithWildCard, pageable);
    }

    public Page<DailyPass> searchByContact(Long climbingGymId, String contact, Pageable pageable) {
        String contactWithWildCard = contact + '%';
        return dailyPassRepository.findByClimbingGymIdAndContactLikeOrderByContactAscRequestDateTimeDesc(climbingGymId, contactWithWildCard, pageable);
    }
}
