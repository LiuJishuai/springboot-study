package com.jeyson.springboot.common.service;

import java.util.Map;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 18:36
 * @Description:
 */
public interface TemplateService {
    String process(Map<String, Object> data, String name);
}
