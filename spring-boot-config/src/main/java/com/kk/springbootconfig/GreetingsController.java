package com.kk.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingsController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value("#{${dbValues}}")
//    private Map<String, String> dbValues;

    @Autowired
    private DBSettings dbSettings;

    @Autowired
    private Environment environment;

    public GreetingsController() {

    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return dbSettings.getConnection() + dbSettings.getHost();
    }

    @GetMapping("/envdetails")
    public String envDetails() {
        return environment.toString();
    }
}
