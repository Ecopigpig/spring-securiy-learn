package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-security
 * @description: 用户服务层实现类
 * @author: linxinting
 * @create: 2020-07-11 17:12
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOneByName(User user) {
        return userMapper.selectOneByName(user);
    }
}
