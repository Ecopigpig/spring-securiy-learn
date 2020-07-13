package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring-security
 * @description: 用户服务层实现类
 * @author: linxinting
 * @create: 2020-07-11 17:12
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectOneByName(String username) {
        return userMapper.selectOneByName(username);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user.getId());
    }
}
