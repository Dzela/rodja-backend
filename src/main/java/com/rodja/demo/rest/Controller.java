package com.rodja.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    @GetMapping("/")
    public String hello() {
        return "Hello, Jelena. Time on server is: " + LocalDateTime.now();
    }

}
