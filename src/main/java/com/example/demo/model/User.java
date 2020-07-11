package com.example.demo.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @program: spring-security
 * @description: 用户数据表
 * 实体类User要实现springsecurity的基本接口UserDetails,UserDetails里继承了Serializable，不用担心序列化
 * @author: linxinting
 * @create: 2020-07-11 16:50
 **/
@Data
public class User implements UserDetails {

    public User(){}

    public User(String userName, String passWord, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.passWord = passWord;
        this.authorities = authorities;
    }

    private static final long serialVersionUID = 9133476958297294605L;

    private Integer id;

    private String userName;

    private Date createdDT;

    private Integer age;

    private Integer gender;

    private String passWord;

    private String role;

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
