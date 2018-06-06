package com.jeyson.springboot.controller;
import com.jeyson.springboot.common.model.JsonResult;
import com.jeyson.springboot.common.service.TemplateService;
import com.jeyson.springboot.utils.NoLogin;
import com.jeyson.springboot.utils.SendMailUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liujishuai
 * @Time: 2018/2/27 10:02
 * @Description:
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @Autowired
    TemplateService templateService;
    @ResponseBody
    @NoLogin
    @RequestMapping("/mail")
    public JsonResult sendMail(String email){
        if(StringUtils.isEmpty(email)){
            return JsonResult.createFailedResult("请输入收件人邮箱");
        }
        Map map=new HashMap<>();
        map.put("url","http://localhost:8080/user/register?email="+email);
        String content=templateService.process(map,"email/register");
        boolean tag= SendMailUtils.sendEmailSmtp("jeyson",email,"534172885@qq.com","我就试一哈",content,null,null);
        if(tag){
            return JsonResult.createSuccessResult("发送成功");
        }
        return JsonResult.createFailedResult("发送失败");

    }
}
