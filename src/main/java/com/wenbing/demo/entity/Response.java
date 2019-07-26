package com.wenbing.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Response<T> {

    private Date responseTime;
    private String code;
    private String status;
    private String message;
    private T data;
}
