package com.namratha.vancouverexplorer.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

//this is a resolver (in java) for the graphql query hello
@Controller
public class HelloQuery {
    @QueryMapping
    public String hello() {
        return "Vancouver Explorer version 1";
    }
}
