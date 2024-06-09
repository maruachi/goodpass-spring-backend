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
    @Column(name = "guest_name")
    private String guestName;
    @Column(name = "contact")
    private String contact;
    @Column(name = "daily_use_contract") @Enumerated(EnumType.STRING)
    private Contract dailyUseContract;
    @Column(name = "privacy_contract") @Enumerated(EnumType.STRING)
    private Contract privacyContract;
    @Column(name = "signature_status") @Enumerated(EnumType.STRING)
    private SignatureStatus signatureStatus;
    @Column(name = "signature_link")
    private String signatureLink;
    @Column(name = "request_datetime")
    private LocalDateTime requestDateTime;

    public void updateSignatureStatus(SignatureStatus signatureStatus) {
        this.signatureStatus = signatureStatus;
        requestDateTime = LocalDateTime.now();
    }

    public void setSignatureLink(String signatureLink) {
        this.signatureLink = signatureLink;
    }
}
