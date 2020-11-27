package com.kq.java.type;

import com.kq.java.type.entity.Company;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParameterizedTypeDemo {

    public static void main(String[] args) {
        // List<User> userList
        // List<String> stringList
        Field[] fs = Company.class.getDeclaredFields();

        for(Field f : fs) {
            System.out.println("");
            Type type = f.getGenericType(); //ParameterizedTypeImpl
            System.out.println("type="+type);
            if(type instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType)type;
                // 参数类型中的原始类型java.uti.List
                Type rawType = pType.getRawType(); // Class  java.uti.List
                System.out.println("rawType="+rawType); // interface java.util.List

                Type ownType = ((ParameterizedType) type).getOwnerType();
                System.out.println("ownType="+ownType);

                Type[] actualTypes = pType.getActualTypeArguments();

                for(Type actualType : actualTypes) {
                    // actualType=class com.kq.java.type.entity.User
                    // actualType=class java.lang.String
                    System.out.println("actualType="+actualType);
                }

            }
        }

    }


}
