package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-security
 * @description: security控制器
 * @author: linxinting
 * @create: 2020-07-11 14:30
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/vercode")
    public String vercode() {
        return "vercode";
    }
}