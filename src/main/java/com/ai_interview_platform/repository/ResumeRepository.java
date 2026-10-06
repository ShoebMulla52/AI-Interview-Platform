package com.ai_interview_platform.repository;




import com.ai_interview_platform.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByCandidateId(Long candidateId);
}
