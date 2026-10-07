package com.ai_interview_platform.repository;



import com.ai_interview_platform.entity.CandidateProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateProfileRepository
        extends JpaRepository<CandidateProfile, Long> {

    Optional<CandidateProfile> findByCandidateId(Long candidateId);
}
