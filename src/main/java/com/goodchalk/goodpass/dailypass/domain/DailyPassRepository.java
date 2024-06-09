package com.goodchalk.goodpass.dailypass.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPassRepository extends JpaRepository<DailyPass, Long> {
}
