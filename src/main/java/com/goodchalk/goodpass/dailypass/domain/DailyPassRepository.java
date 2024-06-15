package com.goodchalk.goodpass.dailypass.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPassRepository extends JpaRepository<DailyPass, Long> {
    Page<DailyPass> findByClimbingGymIdOrderByRequestDateTimeDesc(Long climbingGymId, Pageable pageable);

    Page<DailyPass> findByClimbingGymIdAndGuestNameLikeOrderByGuestNameAscRequestDateTimeDesc(Long climbingGymId, String guestName, Pageable pageable);

    Page<DailyPass> findByClimbingGymIdAndContactLikeOrderByContactAscRequestDateTimeDesc(Long climbingGymId, String contact, Pageable pageable);
}
