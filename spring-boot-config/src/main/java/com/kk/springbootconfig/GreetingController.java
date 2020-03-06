package com.kk.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${app.name}")
    private String appName;

    @Value("${app.desc}")
    private String appDescription;

    @Value("${app.version: 1.0.0}")
    private String defaultValue;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${db.values}}")
    private Map<String, String> dbValues;

    @GetMapping("/greeting")
    public String getGreeting() {
        return staticMessage + defaultValue + listValues + dbValues;
    }

    public GreetingController() {

    }
}