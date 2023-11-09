package com.example.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTestController {
    @GetMapping("/test")
    public String test(){
        return "설정테스트";
    }


    @PostMapping("/test")
    public String test1(){
        return "설정 테스트";
    }
}
