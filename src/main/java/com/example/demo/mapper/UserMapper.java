package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: spring-security
 * @description: 用户DAO
 * @author: linxinting
 * @create: 2020-07-11 17:02
 **/
@Mapper
public interface UserMapper {
    User selectOneByName(User user);
}
