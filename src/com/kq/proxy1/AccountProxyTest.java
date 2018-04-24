package com.kq.proxy1;

import com.kq.mapper.AccountMapper;

public class AccountProxyTest {

    public static void main(String[] args) {
        AccountProxy proxy = new AccountProxy();
        AccountMapper accountMapper = AccountProxyFactory.newInstance(proxy);

        String username = accountMapper.getUsername("123");
        System.out.println("username="+username);
    }

}
