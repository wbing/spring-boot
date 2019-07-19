package com.wenbing.demo.typehandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E>{

    private Class<E> type;

    public BaseEnumTypeHandler(Class<E> type) {
        this.type = type;
    }

    public BaseEnumTypeHandler() {
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        if(jdbcType==null){
            preparedStatement.setString(i,e.toString());
        }else{
            preparedStatement.setObject(i,e.name(),jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return get(resultSet.getString(s));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return get(resultSet.getString(i));
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return get(callableStatement.getString(i));
    }

    private <E extends Enum<E>> E get(int value){
        Method method=null;
        E result=null;
        try {
            method=type.getMethod("getEnum",int.class);
            result= (E) method.invoke(type,value);
        } catch (NoSuchMethodException e) {
            result= (E) Enum.valueOf(type,String.valueOf(value));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private <E extends Enum<E>> E get(String s){
        if(s==null){
            return null;
        }
        if(StringUtils.isNumeric(s)){
            return get(Integer.valueOf(s));
        }else{
            return (E) Enum.valueOf(type,s);
        }
    }
}
