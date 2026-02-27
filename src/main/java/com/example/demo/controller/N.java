package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/n/")
public class N {
    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("hi")
    public String hi(){
        return "Hi";
    }
}
