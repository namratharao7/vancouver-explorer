package com.namratha.vancouverexplorer.ai;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    private final ChatModel chatModel;

    public GeminiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String askGemini(String prompt) {
        //calling chat() actually sends a request to Gemini's API
        return chatModel.chat(prompt);
    }
}
