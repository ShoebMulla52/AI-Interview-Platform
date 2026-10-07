package com.ai_interview_platform.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResumeAnalysisResult {

    private String currentRole;

    private List<String> skills;

    private List<String> technologies;
}
