package com.jeyson.springboot;
import com.jeyson.springboot.common.model.JsonResult;
import com.jeyson.springboot.dao.User;
import com.jeyson.springboot.utils.NoLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 10:50
 * @Description:
 */
@Controller
public class TestController {
    @NoLogin
    @ResponseBody
    @RequestMapping("/hello")
    public JsonResult getWelcome(String param){
        return JsonResult.createSuccessResult("欢迎测试:"+param);
    }

    @NoLogin
    @ResponseBody
    @RequestMapping("/helloJson")
    public JsonResult getWelcome(@RequestBody User user){
        return JsonResult.createSuccessResult(user);
    }
    @NoLogin
    @RequestMapping("")
    public String getIndex(){
        return "test/home";
    }
}
