package com.jeyson.springboot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @Author: liujishuai
 * @Time: 2018/2/27 10:24
 * @Description:
 */
public class PropertiesUtil {
    public static Properties properties = new Properties();
    public static List<String> configFile = Arrays.asList(
            "application.properties");
    static {
        try {
            for(String fileName:configFile) {
                InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
                properties.load(in);
            }
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件错误！");
        }
    }
    public static String getValue(String key){
        return properties.getProperty(key,"");
    }
}
