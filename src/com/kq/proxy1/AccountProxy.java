package com.kq.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AccountProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return null;

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }

        System.out.println("start------------------------- ");
//        Object result =  method.invoke(this, args);
        Object result =  "guest";
        System.out.println("e-n-d-------------------------- result="+result);
        return result;
    }
}
