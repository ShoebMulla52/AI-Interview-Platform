package com.ai_interview_platform.controller;



import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final ChatClient chatClient;

    public AIController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/test")
    public String testAI() {

        return chatClient
                .prompt()
                .user("Explain Java HashMap in simple words.")
                .call()
                .content();
    }
}