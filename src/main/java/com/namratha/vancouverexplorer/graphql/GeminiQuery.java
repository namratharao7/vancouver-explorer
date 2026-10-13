package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.ai.GeminiService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GeminiQuery {
    private final GeminiService geminiService;

    public GeminiQuery(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @QueryMapping
    public String askGemini(@Argument String prompt) {
        return geminiService.askGemini(prompt);
    }
}
