package com.goodchalk.goodpass.dailypass.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "daily_pass")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DailyPass {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "climbing_gym_id")
    private Long climbingGymId;
    @Column(name = "signature_status")
    private SignatureStatus signatureStatus;
    @Column(name = "guest_name")
    private String guestName;
    @Column(name = "contact")
    private String contact;
    @Column(name = "daily_use_contract")
    private Contract dailyUseContract;
    @Column(name = "privacy_contract")
    private Contract privacyContract;
    @Column(name = "request_datetime")
    private LocalDateTime requestDateTime;
    @Column(name = "signature_link")
    private String signatureLink;
}
