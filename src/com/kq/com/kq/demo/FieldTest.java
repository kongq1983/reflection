package com.kq.com.kq.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldTest {

    private Integer age;
    private String name;
    private Boolean open;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Boolean getOpen() {
        return open;
    }

    public static void main(String[] args) {
         Field[] fs = FieldTest.class.getDeclaredFields();

         for (Field f : fs) {
             //declaringClsss: 获取字段定义所在类的class对象  genericType:字段定义类型
             System.out.println("field name="+f.getName()+" declaringClsss="+f.getDeclaringClass()+" genericType="+f.getGenericType());
         }

        Method[] ms = FieldTest.class.getDeclaredMethods();

         for(Method m : ms) {
             //获取字段定义所在类的class对象  genericReturnType : 函数返回定义类型
             System.out.println("method name="+m.getName()+" declaringClsss="+m.getDeclaringClass()+" genericReturnType="+m.getGenericReturnType());
         }

    }

}
