package com.wenbing.demo.util;

import com.wenbing.demo.entity.Response;

public class ResponseUtil {
    private static final String RESPONSE_STATUS_OK = "200";
    private static final String RESPONSE_CODE_SUCCESS = "000000";
    private static final String RESPONSE_MESSAGE_SUCCESS = "请求成功";

    public static <T> Response<T> bizError(String code, String desc, T data) {
        Response<T> response = new Response();
        response.setCode(code);
        response.setMessage(desc);
        response.setResponseTime(DateUtils.getCurrentDate());
        response.setStatus(RESPONSE_STATUS_OK);
        response.setData(data);
        return response;
    }

    public static Response<Void> success() {
        Response<Void> response = setCommonResponseSuccessProperties();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = setCommonResponseSuccessProperties();
        response.setData(data);
        return response;
    }

    private static <T> Response<T> setCommonResponseSuccessProperties() {
        Response<T> response = new Response();
        response.setMessage(RESPONSE_MESSAGE_SUCCESS);
        response.setCode(RESPONSE_CODE_SUCCESS);
        response.setStatus(RESPONSE_STATUS_OK);
        response.setResponseTime(DateUtils.getCurrentDate());
        return response;
    }
}
