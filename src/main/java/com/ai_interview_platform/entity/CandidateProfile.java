package com.ai_interview_platform.entity;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "candidate_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id", nullable = false, unique = true)
    private Candidate candidate;

    @Column(length = 150)
    private String currentRole;

    private Double totalExperience;

    @Column(columnDefinition = "TEXT")
    private String skills;

    @Column(columnDefinition = "TEXT")
    private String technologies;

    @Column(columnDefinition = "LONGTEXT")
    private String projects;

    @Column(columnDefinition = "LONGTEXT")
    private String education;

    @Column(columnDefinition = "LONGTEXT")
    private String certifications;

    private LocalDateTime analyzedAt;

    @PrePersist
    public void onCreate() {
        analyzedAt = LocalDateTime.now();
    }
}
