package com.namratha.vancouverexplorer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//This class contains methods that handle web requests, and their return values
// should be written into HTTP responses.
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Vancouver Explorer version 1";
    }
}
