package com.jeyson.springboot.common.model;

import java.io.Serializable;

/**
 * @Author: liujishuai
 * @Time: 2018/2/27 15:04
 * @Description:
 */
public class JeysonException extends RuntimeException implements Serializable {
    public JeysonException(String message){
         super(message,new Throwable(message));
    }
    public JeysonException(Throwable cause){
        super(cause);
    }
    public JeysonException(String message, Throwable cause){
        super(message,cause);
    }
}
