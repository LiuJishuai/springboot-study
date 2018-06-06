package com.jeyson.springboot.service;

import com.jeyson.springboot.dao.User;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:50
 * @Description:
 */
public interface UserService {

     User addUser(String account,String username,String password);

     /**
      * 是否可注册的邮箱（1-格式正确 2-未被使用）
      * @param email
      * @return
      */
     boolean isAvailableRegEmail(String email);
}
