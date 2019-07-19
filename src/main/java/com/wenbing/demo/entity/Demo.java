package com.wenbing.demo.entity;

import com.wenbing.demo.typehandler.GenderEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demo {
    private String id;
    private String realName;
    private GenderEnum gender;
}
