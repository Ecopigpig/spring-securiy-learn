package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/delete")
    public String delete() {
        return "success";
    }
}
