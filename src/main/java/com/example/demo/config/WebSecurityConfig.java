package com.example.demo.config;

import com.example.demo.handler.MyAccessDeniedHandler;
import com.example.demo.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @program: spring-security
 * @description: security 针对role角色判断配置
 * @author: linxinting
 * @create: 2020-07-13 09:47
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                //不限制访问的路径,如访问http://localhost:6061/user/hello就不需要登录
                .antMatchers("/user/*").permitAll()
                //用户拥有规定角色才允许访问的路径,如访问http://localhost：6061/user/delete?id=2就会跳转到SpringSecurity的登录页面
                .antMatchers("/user/delete").hasRole("admin")
                //规定ip才允许访问的路径
                .antMatchers("/*").hasIpAddress("127.0.0.1/24")
                .anyRequest().authenticated()
                .and()
                //跳转自定义成功页，
                .formLogin().defaultSuccessUrl("/static/index.html")
                .and()
                .exceptionHandling()
                //用户无权限访问链接，给出友好提示，如果直接访问http://localhost：6061，则会直接跳转到这个页面~
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .csrf().disable();//post请求要关闭csrf验证，不然访问报错；实际开发中哟啊开启
    }
}
