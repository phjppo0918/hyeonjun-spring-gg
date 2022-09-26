package com.example.hyeonjunspringgg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/member")
public class LoginMemberController {
    @GetMapping
    public String hello() {
        return "hello";
    }
}

