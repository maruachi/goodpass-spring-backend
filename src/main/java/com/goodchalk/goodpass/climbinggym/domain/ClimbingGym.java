package com.goodchalk.goodpass.climbinggym.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "climbing_gym")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ClimbingGym {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "climbing_gym_name")
    private String climbingGymName;
    @Column(name = "address")
    private String address;
    @Column(name = "instagram_account")
    private String instagramAccount;
    @Column(name = "register_datetime")
    private LocalDateTime requestDateTime;

    public void recordRequestTime() {
        requestDateTime = LocalDateTime.now();
    }
}
