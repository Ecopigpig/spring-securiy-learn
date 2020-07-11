package com.example.demo.service;

import com.example.demo.model.User;

/**
 * @program: spring-security
 * @description: 用户服务层
 * @author: linxinting
 * @create: 2020-07-11 17:11
 **/
public interface UserService {
    User selectOneByName(User user);
}
