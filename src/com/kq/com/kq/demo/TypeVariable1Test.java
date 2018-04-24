package com.kq.com.kq.demo;

import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

public class TypeVariable1Test {

    //ParameterizedType,ParameterizedType
    public void print(List<? extends Number> list, Map<String,Integer> map) {
        System.out.println("list=" + list);
    }

    //GenericArrayType
    public void print(List<? extends Number>[] list) {
        System.out.println("list=" + list);
    }

    public void printOne(List<? extends Number> list) {
        System.out.println("list=" + list);
    }

    public static void main(String[] args) {

        Method[] ms = TypeVariable1Test.class.getDeclaredMethods();

        for (Method m : ms) {
            if(!m.getName().startsWith("print"))continue;
            //参数类型
            Type[] types = m.getGenericParameterTypes();

            for(Type t : types){
                System.out.println(t);
                dealType(t);
            }
            System.out.println("-------------------------");
        }
    }

    public static void dealType(Type t) {
        
        if(t instanceof TypeVariable){
            System.out.println("t instanceof TypeVariable");
        }else if(t instanceof ParameterizedType){
            System.out.println("t instanceof ParameterizedType");
        }else if(t instanceof WildcardType){
            System.out.println("t instanceof WildcardType");
        }else if(t instanceof GenericArrayType){
            System.out.println("t instanceof GenericArrayType");
        }else {
            System.out.println("not found match type type=");
        }
    }
}
