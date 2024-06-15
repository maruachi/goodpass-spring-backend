package com.goodchalk.goodpass.dailypass.service;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SearchType;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyPassesSearchService {
    private final DailyPassesConditionSearchService dailyPassesConditionSearchService;
    public Page<DailyPass> search(Long climbingGymId, SearchType searchType, String searchCondition, Pageable pageable) {
        if (searchType == SearchType.NO_CONDITION) {
            return dailyPassesConditionSearchService.searchByNoCondition(climbingGymId, pageable);
        }

        if (searchType == SearchType.NAME) {
            return dailyPassesConditionSearchService.searchByName(climbingGymId, searchCondition, pageable);
        }

        if (searchType == SearchType.CONTACT) {
            return dailyPassesConditionSearchService.searchByContact(climbingGymId, searchCondition, pageable);
        }

        throw new GoodPassBusinessException("적절하지 않은 검색 조건입니다. searchType = " + searchType);
    }
}
