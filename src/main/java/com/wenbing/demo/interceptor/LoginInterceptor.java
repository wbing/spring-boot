package com.wenbing.demo.interceptor;

import com.wenbing.demo.constant.LoginConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(StringUtils.isNotEmpty(request.getHeader(LoginConstant.TOKEN))){
            String token = request.getHeader(LoginConstant.TOKEN);
            if(redisTemplate.opsForValue().get(token)!=null){


                //更新token时间
                redisTemplate.expire(token,3600, TimeUnit.SECONDS);
            }

        }else{
            response.setStatus(404);
            throw new RuntimeException("请登录");
        }
        return true;
    }

}
