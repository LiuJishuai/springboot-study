package com.jeyson.springboot.service.impl;

import com.jeyson.springboot.common.model.JeysonException;
import com.jeyson.springboot.dao.User;
import com.jeyson.springboot.mapper.UserMapper;
import com.jeyson.springboot.service.UserService;
import com.jeyson.springboot.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:51
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserMapper userMapper;

    @Override
    public User addUser(String account, String username, String password) {
        isAvailableRegEmail(account);
        User user = new User();
        user.setAccount(account);
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public boolean isAvailableRegEmail(String email) {
        if(!StringUtils.isEmail(email)){
            throw new JeysonException("邮箱格式不正确。");
        }
        int num=userMapper.getUserNumByAccount(email);
        if(num>0){
            throw new JeysonException("该邮箱已经注册。");
        }
       return true;
    }


}
