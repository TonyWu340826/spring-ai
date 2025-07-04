package com.example.springai;

import org.springframework.ai.client.AiClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiDemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner demo(AiClient aiClient) {
        return args -> {
            System.out.println("\n=== AI Demo Started ===\n");
            
            // Simple prompt
            String response = aiClient.generate("Tell me a joke about Spring Boot");
            System.out.println("AI Response: " + response);
            
            // More complex interaction
            String advice = aiClient.generate("""
                As a senior Java developer, give me 3 best practices 
                for using Spring AI in production applications.
                """);
            System.out.println("\nAI Advice:\n" + advice);
        };
    }
}