package com.wenbing.demo.hello;

import com.wenbing.demo.config.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("hello controller")
@RestController
public class HelloController {

    @Value("${demo.name}")
    @Getter
    @Setter
    private String name;

    @Autowired
    private Student std;

    @ApiOperation(value = "helloGet 接口")
    @GetMapping("hello")
    public String hello(){
        return "helllo,my name is "+this.getName();
    }

    @ApiOperation(value = "helloPost 接口")
    @PostMapping("hello")
    public String posthello()
    {
        return "input hello";
    }

    @GetMapping("getName")
    public String getStdName(){
        return std.getName();
    }
}
