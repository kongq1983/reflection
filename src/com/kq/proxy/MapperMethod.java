package com.kq.proxy;

import java.lang.reflect.Method;

public class MapperMethod {

    public MapperMethod(Class<?> mapperInterface, Method method) {
        System.out.println("mapperInterface="+mapperInterface);
        System.out.println("method="+method);
    }

    public Object execute(String methodName, Object[] args) {

        System.out.println("MapperMethod methodName="+methodName);

        if("getUsername".equals(methodName)){
            return this.getUsername(args);
        }

        return  null;

    }

    public String getUsername(Object[] args){
        return "admin_"+ args[0];
    }

}
