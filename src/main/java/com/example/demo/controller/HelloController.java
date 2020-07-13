package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-security
 * @description: security控制器
 * @author: linxinting
 * @create: 2020-07-11 14:30
 **/
@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 这个权限的标识是可以自定义的，只要跟数据库中的权限表对应即可
     * @return
     */
//    @PreAuthorize("hasRole('user')")
    @PreAuthorize("hasRole('abc')")
    @GetMapping("/vercode")
    public String vercode() {
        return "vercode";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam int id) {
        int i = userService.delete(new User(){
            @Override
            public void setId(Integer id) {
                super.setId(id);
            }
        });
        return "success";
    }
}
