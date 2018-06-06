package com.jeyson.springboot.utils;

import java.lang.annotation.*;

/**
 * @Author: liujishuai
 * @Time: 2018/2/28 11:46
 * @Description:
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoLogin {
}
