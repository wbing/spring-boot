package com.wenbing.demo.typehandler;

import org.apache.ibatis.type.MappedTypes;

/**
 * 如果新加枚举类，需要实现重写toString 和 getEnum方法
 * @param <E>
 */
@MappedTypes(value = {GenderEnum.class})
public class EnumTypeHandler<E extends Enum<E>> extends BaseEnumTypeHandler<E> {
    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
