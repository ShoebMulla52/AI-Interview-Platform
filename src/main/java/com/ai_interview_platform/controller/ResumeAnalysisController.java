package com.ai_interview_platform.controller;



import com.ai_interview_platform.service.ResumeAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume-analysis")
@RequiredArgsConstructor
public class ResumeAnalysisController {

    private final ResumeAnalysisService resumeAnalysisService;

    @PostMapping("/{candidateId}")
    public ResponseEntity<String> analyzeResume(
            @PathVariable Long candidateId) {

        return ResponseEntity.ok(
                resumeAnalysisService.analyzeResume(candidateId)
        );
    }
}