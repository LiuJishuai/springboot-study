package com.jeyson.springboot.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:20
 * @Description:
 */
@Data
public class User implements Serializable{
    private Long id;
    private String account;
    private String username;
    private String password;
}
