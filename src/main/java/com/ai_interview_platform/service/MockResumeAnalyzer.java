package com.ai_interview_platform.service;


import com.ai_interview_platform.dto.ResumeAnalysisResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockResumeAnalyzer {

    public ResumeAnalysisResult analyze(String resumeText) {

        String text = resumeText.toLowerCase();

        List<String> skills = new ArrayList<>();
        List<String> technologies = new ArrayList<>();

        if (text.contains("java")) {
            skills.add("Java");
            technologies.add("Java");
        }

        if (text.contains("spring boot")) {
            skills.add("Spring Boot");
            technologies.add("Spring Boot");
        }

        if (text.contains("microservices")) {
            skills.add("Microservices");
            technologies.add("Microservices");
        }

        if (text.contains("react")) {
            skills.add("React.js");
            technologies.add("React.js");
        }

        if (text.contains("angular")) {
            skills.add("Angular");
            technologies.add("Angular");
        }

        if (text.contains("mysql")) {
            skills.add("MySQL");
            technologies.add("MySQL");
        }

        if (text.contains("postgresql")) {
            skills.add("PostgreSQL");
            technologies.add("PostgreSQL");
        }

        if (text.contains("kafka")) {
            skills.add("Kafka");
            technologies.add("Apache Kafka");
        }

        if (text.contains("docker")) {
            skills.add("Docker");
            technologies.add("Docker");
        }

        if (text.contains("kubernetes")) {
            skills.add("Kubernetes");
            technologies.add("Kubernetes");
        }

        String currentRole = null;

        if (text.contains("java full stack developer")) {
            currentRole = "Java Full Stack Developer";
        } else if (text.contains("software engineer")) {
            currentRole = "Software Engineer";
        } else if (text.contains("developer")) {
            currentRole = "Software Developer";
        }

        return new ResumeAnalysisResult(
                currentRole,
                skills,
                technologies
        );
    }
}
