package com.goodchalk.goodpass.dailypass.controller.dto;

import com.goodchalk.goodpass.dailypass.domain.DailyPass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Builder
@Getter
@Setter
public class DailyPassesSearchResponseDto {
    private Page<DailyPass> dailyPasses;

    public static DailyPassesSearchResponseDto of(Page<DailyPass> dailyPasses) {
        return DailyPassesSearchResponseDto.builder().dailyPasses(dailyPasses).build();
    }
}
