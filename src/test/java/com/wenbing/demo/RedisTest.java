package com.wenbing.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Profile("dev")
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testRedisSet(){
        redisTemplate.opsForValue().set("hello","world1");
    }
    @Test
    public void testRedisGet(){
        String result=(String)redisTemplate.opsForValue().get("hello");
        System.out.println("--------------"+result);
    }
}
