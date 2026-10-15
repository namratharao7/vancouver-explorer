package com.namratha.vancouverexplorer.graphql;

import com.namratha.vancouverexplorer.ai.ExplorerAssistant;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

//This is a graphQL resolver for the exploreVancouver query
@Controller
public class ExplorerQuery {
    private final ExplorerAssistant explorerAssistant;
    public ExplorerQuery(ExplorerAssistant explorerAssistant) {
        this.explorerAssistant = explorerAssistant;
    }

    @QueryMapping
    public String exploreVancouver(@Argument String request) {
        return  explorerAssistant.explore(request);
    }
}
