package com.jeyson.springboot.common.service.impl;

import com.jeyson.springboot.common.service.TemplateService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 18:37
 * @Description:
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public String process(Map<String, Object> data, String name) {
        Template template = this.getTemplate(name);
        if (template != null) {
            try {
                Writer out = new StringWriter();
                template.process(data, out);
                return out.toString();
            } catch (TemplateException e) {
                logger.error("获取模板文件： (" + name + ") 发生异常： ", e);
            } catch (IOException e) {
                logger.error("获取模板文件： (" + name + ") 发生异常： ", e);
            }
        }
        return null;
    }

    private Template getTemplate(String name) {
        String templateName = name;
        if (!StringUtils.endsWith(name, ".ftl")) {
            templateName = name + ".ftl";
        }

        Template template = null;

        try {
            template = this.freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            return template;
        } catch (IOException e) {
            logger.error("获取模板文件： (" + name + ") 发生异常： ", e);
            return null;
        }
    }
}
