package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.ai.ExplorerAssistant;
import dev.langchain4j.exception.RateLimitException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//This is a graphQL resolver for the exploreVancouver query
@Controller
public class ExplorerQuery {
    private final ExplorerAssistant explorerAssistant;
    public ExplorerQuery(ExplorerAssistant explorerAssistant) {
        this.explorerAssistant = explorerAssistant;
    }

    private static final Logger logger = LoggerFactory.getLogger(ExplorerQuery.class);

    @QueryMapping
    public String exploreVancouver(@Argument String request) {
        try {
            return explorerAssistant.explore(request);
        } catch(RateLimitException e) {
            logger.warn("Gemini API rate limit exceeded while exploring Vancouver", e);
            return "Our AI assistant is temporarily unavailable due to high demand. Please try again later.";
        }
    }
}
