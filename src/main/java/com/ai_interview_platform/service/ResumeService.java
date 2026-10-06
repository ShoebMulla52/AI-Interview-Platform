package com.ai_interview_platform.service;



import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

    String uploadResume(Long candidateId, MultipartFile file);
}