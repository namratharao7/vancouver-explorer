package com.namratha.vancouverexplorer.ai;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public ChatModel geminiChatModel() {
        return GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-3.8-flash")
                .maxRetries(0)
                .build();
    }
    //LangChain4j dynamically creates the implementation for the
    // ExplorerAssistance interface for us
    @Bean
    public ExplorerAssistant explorerAssistant(
            ChatModel chatModel,
            PlaceTools placeTools) {
        return AiServices.builder(ExplorerAssistant.class)
                .chatModel(chatModel)
                .tools(placeTools)
                .build();
    }
}
