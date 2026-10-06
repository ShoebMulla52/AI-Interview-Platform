package com.ai_interview_platform.controller;


import com.ai_interview_platform.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(
            value = "/upload",
            consumes = "multipart/form-data"
    )
    public ResponseEntity<String> uploadResume(
            @RequestParam Long candidateId,
            @RequestParam MultipartFile file) {

        String response =
                resumeService.uploadResume(candidateId, file);

        return ResponseEntity.ok(response);
    }
}
