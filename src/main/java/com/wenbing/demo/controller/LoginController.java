package com.wenbing.demo.controller;

import com.wenbing.demo.entity.Response;
import com.wenbing.demo.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("login")
    @ApiOperation(value = "用户登录")
    public Response login(@RequestParam String userName,@RequestParam String password){

        redisTemplate.opsForValue().set("token","user");
        System.out.println("登录用户："+userName);
        return ResponseUtil.success();
    }
}
