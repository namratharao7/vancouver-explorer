package com.namratha.vancouverexplorer.ai;

import dev.langchain4j.service.SystemMessage;

//LangChain4j can generate this interface's implementation dynamically through AiServices
public interface ExplorerAssistant {
    @SystemMessage("""
            You are a Vancouver exploration assistant.
            Use the available tools to find Vancouver places.
            Base your recommendations on the places returned by the tools.
            Do not invent places or prices.
            """)
    String explore(String userRequest);
}
