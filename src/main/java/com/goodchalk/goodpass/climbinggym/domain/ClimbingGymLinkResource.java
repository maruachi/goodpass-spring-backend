package com.goodchalk.goodpass.climbinggym.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="climbing_gym_link_resource")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClimbingGymLinkResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long climbingGymId;
    @Enumerated(EnumType.STRING)
    private ResourceStatus resourceStatus;
    @Enumerated(EnumType.STRING)
    private LinkResourceType linkResourceType;
    private String link;
    private LocalDateTime requestDateTime;

    @PrePersist
    protected void onCreate() {
        resourceStatus = ResourceStatus.ACTIVE;
        requestDateTime = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        requestDateTime = LocalDateTime.now();
    }

    public void setLink(String posterLink) {
        this.link = posterLink;
    }

    public void setResourceType(ResourceStatus resourceStatus) {
        this.resourceStatus = resourceStatus;
    }
}
