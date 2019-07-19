package com.wenbing.demo;

import com.wenbing.demo.entity.Demo;
import com.wenbing.demo.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMapperTest {

    @Autowired
    private DemoMapper mapper;

    @Test
    public void findList() {
        List<Demo> list = mapper.findList();
        Assert.isTrue(list.size()==1,"数量bu");
    }
}