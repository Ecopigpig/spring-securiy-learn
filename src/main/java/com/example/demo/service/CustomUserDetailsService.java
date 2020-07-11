package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-security
 * @description: 自定义获取用户信息和角色信息
 * @author: linxinting
 * @create: 2020-07-11 17:28
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectOneByName(new User() {
            @Override
            public void setUserName(String userName) {
                super.setUserName(userName);
            }
        });
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        HttpSession session = request.getSession();
        session.setAttribute(session.getId(), user);
        //得到用户角色
        String role = user.getRole();
        //角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        //角色必须以‘ROLE_’开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
