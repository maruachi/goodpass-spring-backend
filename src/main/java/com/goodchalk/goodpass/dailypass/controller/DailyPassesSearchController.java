package com.goodchalk.goodpass.dailypass.controller;

import com.goodchalk.goodpass.dailypass.controller.dto.DailyPassesSearchResponseDto;
import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import com.goodchalk.goodpass.dailypass.domain.SearchType;
import com.goodchalk.goodpass.dailypass.service.DailyPassesSearchService;
import com.goodchalk.goodpass.exception.GoodPassBusinessException;
import com.goodchalk.goodpass.jwt.AdminUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DailyPassesSearchController {
    private final DailyPassesSearchService dailyPassesSearchService;
    @RequestMapping(value = "/dailypasses/climbinggym/{climbingGymId}", method = RequestMethod.GET)
    @PreAuthorize("#climbingGymId == principal.adminRoleValue")
    public DailyPassesSearchResponseDto search(@PathVariable Long climbingGymId,
                                               @RequestParam SearchType searchType,
                                               @RequestParam(required = false) String searchCondition,
                                               @RequestParam int page,
                                               @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<DailyPass> dailyPasses = dailyPassesSearchService.search(climbingGymId, searchType, searchCondition, pageable);
        return DailyPassesSearchResponseDto.of(dailyPasses);
    }

}
