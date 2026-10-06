package com.ai_interview_platform.repository;




import com.ai_interview_platform.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}