package com.kq.proxy1;

import com.kq.mapper.AccountMapper;

import java.lang.reflect.Proxy;

public class AccountProxyFactory {

    public static AccountMapper newInstance(AccountProxy proxy) {

//        mapperProxy.getClass().getClassLoader()
        return (AccountMapper) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[] {AccountMapper.class }, proxy);
    }

}
