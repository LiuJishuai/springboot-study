package com.jeyson.springboot.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:55
 * @Description:
 */
@Data
public class JsonResult implements Serializable {
    public boolean success;
    public Object data;
    public String errorMsg;

    public static JsonResult createSuccessResult(Object data) {
        JsonResult result = new JsonResult();
        result.setData(data);
        result.setErrorMsg(null);
        result.setSuccess(true);
        return result;
    }

    public static JsonResult createFailedResult(String errorMsg) {
        JsonResult result = new JsonResult();
        result.setData(null);
        result.setErrorMsg(errorMsg);
        result.setSuccess(false);
        return result;
    }

    public static JsonResult createFailedResult(Object data, String errorMsg) {
        JsonResult result = new JsonResult();
        result.setData(data);
        result.setErrorMsg(errorMsg);
        result.setSuccess(false);
        return result;
    }
}
