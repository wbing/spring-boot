package com.wenbing.demo.mapper;

import com.wenbing.demo.entity.Demo;
import com.wenbing.demo.typehandler.GenderEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoMapper {

    @Select("select * from demo")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "realName",column = "real_name"),
            @Result(property = "gender",column = "gender",javaType = GenderEnum.class)
    })
    List<Demo> findList();

}
