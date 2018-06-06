package com.jeyson.springboot.controller;

import com.jeyson.springboot.common.controller.BaseController;
import com.jeyson.springboot.common.model.JeysonException;
import com.jeyson.springboot.common.model.JsonResult;
import com.jeyson.springboot.common.service.TemplateService;
import com.jeyson.springboot.dao.User;
import com.jeyson.springboot.service.UserService;
import com.jeyson.springboot.utils.NoLogin;
import com.jeyson.springboot.utils.SendMailUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:48
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    TemplateService templateService;
    @ResponseBody
    @RequestMapping("/addUser")
    public JsonResult addNewUser(@RequestParam("account")String account,
                                 @RequestParam("username")String username,
                                 @RequestParam("password")String password){
        User user= userService.addUser(account,username,password);
        return JsonResult.createSuccessResult(user);
    }


    @ResponseBody
    @NoLogin
    @RequestMapping("/registerMail")
    public JsonResult sendMail(String email){
        if(StringUtils.isEmpty(email)){
            return JsonResult.createFailedResult("请输入收件人邮箱");
        }
        userService.isAvailableRegEmail(email);
        Map map=new HashMap<>();
        map.put("url","http://localhost:8080/user/register?email="+email);
        String content=templateService.process(map,"email/register");
        boolean tag= SendMailUtils.sendEmailSmtp("jeyson",email,"534172885@qq.com","我就试一哈",content,null,null);
        if(tag){
            return JsonResult.createSuccessResult("发送成功");
        }
        return JsonResult.createFailedResult("发送失败");

    }
    @NoLogin
    @ResponseBody
    @RequestMapping("/register")
    public JsonResult addNewUser(String email){
        if(StringUtils.isEmpty(email)){
            throw new JeysonException("参数错误");
        }
        User user= userService.addUser(email,email,"jeyson");
        return JsonResult.createSuccessResult(user);
    }
}
