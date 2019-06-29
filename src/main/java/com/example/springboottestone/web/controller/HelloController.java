package com.example.springboottestone.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot!";
    }
}
