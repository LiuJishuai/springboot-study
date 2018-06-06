package com.jeyson.springboot.common.controller;

import com.jeyson.springboot.common.model.JeysonException;
import com.jeyson.springboot.common.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @Author: liujishuai
 * @Time: 2018/2/27 15:07
 * @Description:
 */
@Controller
public class BaseController {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * json版本错误处理
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    @RequestMapping("/error.do")
    public JsonResult expHandler(HttpServletRequest request, Exception ex) {
        // 记录错误日志
        HashMap<String, Object> log = new HashMap<>();
        log.put("ip", request.getRemoteAddr());
        log.put("method", request.getMethod());
        log.put("url", request.getRequestURL().toString());
        log.put("headers", getRequestHeaders(request));
        log.put("params", getRequestParams(request));
        //logger.error("baseController查获错误："+ JSON.toJSONString(log));
        if(ex instanceof JeysonException) {
            String errorMsg = ex.getMessage();
            return JsonResult.createFailedResult(errorMsg);
        } else {
           return JsonResult.createFailedResult(ex.getMessage());
        }
    }

    /**
     * 页面版本
     * @param request
     * @param ex
     * @return
     */
//    @ExceptionHandler
//    @RequestMapping("/error.do")
//    public ModelAndView expHandler(HttpServletRequest request, Exception ex) {
//        ModelAndView mv=new ModelAndView("error");
//        // 记录错误日志
//        HashMap<String, Object> log = new HashMap<>();
//        log.put("ip", request.getRemoteAddr());
//        log.put("method", request.getMethod());
//        log.put("url", request.getRequestURL().toString());
//        log.put("headers", getRequestHeaders(request));
//        log.put("params", getRequestParams(request));
//        logger.error("baseController查获错误："+ JSON.toJSONString(log));
//        mv.addObject("msg",ex.getMessage());
//        return mv;
//    }
    /**
     * 获取请求头
     * @return
     */
    protected HashMap<String, String> getRequestHeaders(HttpServletRequest request)  {
        HashMap<String, String> requestHeaders = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            requestHeaders.put(headerName, headerValue);
        }
        return requestHeaders;
    }

    /**
     * 获取请求
     * @return
     */
    protected HashMap<String, String> getRequestParams(HttpServletRequest request) {
        HashMap<String, String> requestParams = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);
            requestParams.put(paramName, paramValue);
        }
        return requestParams;
    }
}
