package com.kq.java.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kq
 * @date 2020-09-01 10:25
 * @since 2020-0630
 */
public class TransactionProxyHandler implements InvocationHandler {

    private Object target;

    public TransactionProxyHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin transaction "  + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("end transaction " + method.getName());
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
