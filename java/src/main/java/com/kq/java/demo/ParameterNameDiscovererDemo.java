package com.kq.java.demo;

import com.kq.java.parameter.ParameterNameDiscoverer;
import com.kq.reflection.entity.SmsBody;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kq
 * @date 2020-09-01 17:00
 * @since 2020-0630
 */
public class ParameterNameDiscovererDemo {

    public static void main(String[] args) throws Exception {
        Constructor constructor = SmsBody.class.getConstructor(String.class, String.class, Integer.class);

        ParameterNameDiscoverer parameterNameDiscoverer = new ParameterNameDiscoverer();
        String[] array = parameterNameDiscoverer.getParameterNames(constructor);

//        for(String a : array){
//            System.out.println("name="+a);
//        }

        List<String> list = getParameterNameJava8(SmsBody.class, "send");

        for(String s : list) {
            System.out.println("name="+s);
        }

    }


    public static List<String> getParameterNameJava8(Class clazz, String methodName){
        List<String> paramterList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                Parameter[] params = method.getParameters();
                for(Parameter parameter : params){
                    paramterList.add(parameter.getName());
                }
            }
        }
        return paramterList;
    }



}
