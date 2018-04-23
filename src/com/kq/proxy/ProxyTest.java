package com.kq.proxy;

import com.kq.mapper.AccountMapper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyTest {

    public static void main(String[] args) {
        Class<AccountMapper> clazz = AccountMapper.class;
        Method m = getMethod();
//        MapperMethod mapperMethod = new MapperMethod(clazz,m);

        Map<Method, MapperMethod> methodCache = new HashMap<>();
        MapperProxy proxy = new MapperProxy(clazz,methodCache);

        MapperProxyFactory<AccountMapper> factory = new MapperProxyFactory(clazz);
        AccountMapper accountMapper = factory.newInstance(proxy);
        String username = accountMapper.getUsername("100");

        System.out.println("username="+username);



//        System.out.println(m);
//        System.out.println(m.getName());

    }

    public static Method getMethod(){

//        for(Method m : AccountMapper.class.getDeclaredMethods()) {
//            System.out.println("find method : "+m+"  name="+m.getName());
//        }

        try {
            Method m = AccountMapper.class.getDeclaredMethod("getUsername",String.class);
            return m;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
