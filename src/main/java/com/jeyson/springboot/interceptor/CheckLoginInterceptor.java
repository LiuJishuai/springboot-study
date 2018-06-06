package com.jeyson.springboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.jeyson.springboot.common.model.JsonResult;
import com.jeyson.springboot.utils.NoLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: liujishuai
 * @Time: 2018/2/28 11:50
 * @Description:
 */
public class CheckLoginInterceptor implements HandlerInterceptor {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handlerMethod) throws Exception {
        if(!(handlerMethod instanceof HandlerMethod)){
            logger.warn("当前操作handler不为HandlerMethod=" + handlerMethod.getClass().getName() + ",req="
                    + request.getQueryString());
            return true;
        }
        HandlerMethod handler=(HandlerMethod)handlerMethod;
        String methodName=handler.getMethod().getName();
        NoLogin noLogin=handler.getMethod().getAnnotation(NoLogin.class);
        if(null != noLogin){
            logger.info("当前method不需要login："+methodName);
            return true;
        }
        if (null == request.getHeader("userId")) {
            logger.warn("当前操作method:" + methodName + ",用户未登录,ip=" + request.getRemoteAddr());
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(JsonResult.createFailedResult("此操作需要登陆"))); // 返回错误信息
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
