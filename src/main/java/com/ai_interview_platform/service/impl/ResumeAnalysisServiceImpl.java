package com.ai_interview_platform.service.impl;



import com.ai_interview_platform.dto.ResumeAnalysisResult;
import com.ai_interview_platform.entity.Candidate;
import com.ai_interview_platform.entity.CandidateProfile;
import com.ai_interview_platform.entity.Resume;
import com.ai_interview_platform.repository.CandidateProfileRepository;
import com.ai_interview_platform.repository.CandidateRepository;
import com.ai_interview_platform.repository.ResumeRepository;
import com.ai_interview_platform.service.MockResumeAnalyzer;
import com.ai_interview_platform.service.ResumeAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeAnalysisServiceImpl implements ResumeAnalysisService {

    private final CandidateRepository candidateRepository;
    private final ResumeRepository resumeRepository;
    private final CandidateProfileRepository candidateProfileRepository;
    private final MockResumeAnalyzer mockResumeAnalyzer;

    @Override
    public String analyzeResume(Long candidateId) {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() ->
                        new RuntimeException("Candidate not found"));

        Resume resume = resumeRepository.findByCandidateId(candidateId)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

        String resumeText = resume.getExtractedText();

        if (resumeText == null || resumeText.isBlank()) {
            throw new RuntimeException("Resume text is empty");
        }

        ResumeAnalysisResult result =
                mockResumeAnalyzer.analyze(resumeText);

        CandidateProfile profile = CandidateProfile.builder()
                .candidate(candidate)
                .currentRole(result.getCurrentRole())
                .skills(String.join(", ", result.getSkills()))
                .technologies(String.join(", ", result.getTechnologies()))
                .projects("")
                .education("")
                .certifications("")
                .build();

        candidateProfileRepository.save(profile);

        return "Resume analyzed successfully";
    }
}
