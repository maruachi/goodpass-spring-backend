package com.goodchalk.goodpass.climbinggym.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimbingGymRepository extends JpaRepository<ClimbingGym, Long> {
}
