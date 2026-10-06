package com.ai_interview_platform.service.impl;


import com.ai_interview_platform.entity.Candidate;
import com.ai_interview_platform.entity.Resume;
import com.ai_interview_platform.repository.CandidateRepository;
import com.ai_interview_platform.repository.ResumeRepository;
import com.ai_interview_platform.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final CandidateRepository candidateRepository;
    private final ResumeRepository resumeRepository;

    private final Tika tika = new Tika();

    @Override
    public String uploadResume(Long candidateId, MultipartFile file) {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() ->
                        new RuntimeException("Candidate not found"));

        try {

            String extractedText = tika.parseToString(file.getInputStream());

            Resume resume = Resume.builder()
                    .candidate(candidate)
                    .fileName(file.getOriginalFilename())
                    .fileType(file.getContentType())
                    .extractedText(extractedText)
                    .build();

            resumeRepository.save(resume);

            return "Resume uploaded and text extracted successfully";

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to process resume: " + e.getMessage());
        }
    }
}
