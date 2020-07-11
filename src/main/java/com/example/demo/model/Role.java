package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: spring-security
 * @description: 角色数据实体
 * @author: linxinting
 * @create: 2020-07-11 16:59
 **/
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 2577108751648707496L;

    private Integer id;

    private String role;

    private Date createDT;

    private Integer userId;
}
