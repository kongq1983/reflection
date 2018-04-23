package com.kq.com.kq.demo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class ParameterizedTypeTest {

//    public String printList(List<String> strLst) {
        public String printList(Map<String,List<String>> strLst) {
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
//                        System.out.println("equal");
                        ParameterizedType type = (ParameterizedType)t;
                        System.out.println("rawType="+type.getRawType());
                        System.out.println("ownerType="+type.getOwnerType());

                        Type[] t1s = type.getActualTypeArguments();
                        for(Type t1 : t1s){
                            System.out.println("t1="+t1);
                        }
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
