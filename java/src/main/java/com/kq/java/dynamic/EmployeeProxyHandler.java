package com.kq.java.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kq
 * @date 2020-09-01 10:02
 * @since 2020-0630
 */
public class EmployeeProxyHandler implements InvocationHandler {

    private Object object;

    public EmployeeProxyHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return result;
    }

}
