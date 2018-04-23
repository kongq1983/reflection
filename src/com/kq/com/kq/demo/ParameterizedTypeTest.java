package com.kq.com.kq.demo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ParameterizedTypeTest {

    public String printList(List<String> strLst) {
        return "";
    }

    public static void parameterizedTypeDemo(){
        Method[] ms  = ParameterizedTypeTest.class.getDeclaredMethods();

        for(Method m : ms) {
            if(m.getName().equals("printList")) {
                System.out.println("printList method : "+m);
                Type[] types = m.getGenericParameterTypes();

                for(Type t : types) {
                    System.out.println(t.getTypeName());
                    System.out.println(t.getClass());
                    if(t instanceof ParameterizedType) {
                        System.out.println("equal");
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        parameterizedTypeDemo();
       //
    }

}
