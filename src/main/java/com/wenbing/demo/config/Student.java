package com.wenbing.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "std")
@Getter
@Setter
public class Student {
    private String name;
    private String age;
}
