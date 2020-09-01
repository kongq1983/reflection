package com.kq.cglib.demo;

import com.kq.cglib.interceptor.TransactionInterceptor;
import com.kq.reflection.entity.Employee;
import com.kq.reflection.entity.SmsBody;
import com.kq.reflection.service.EmployeeService;
import com.kq.reflection.service.impl.EmployeeServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author kq
 * @date 2020-09-01 14:35
 * @since 2020-0630
 */
public class SmsBodyConstructorDemo {

    public static void main(String[] args) {

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(SmsBody.class);
        //设置接口
//        enhancer.setInterfaces(new Class[]{EmployeeService.class});
        //设置回调函数
        enhancer.setCallback(new TransactionInterceptor());

        //这里的creat方法就是正式创建代理类
//        EmployeeServiceImpl employeeServiceProxy = (EmployeeServiceImpl)enhancer.create();
//        SmsBody smsBody = (SmsBody)enhancer.create();  // 由于没有默认构造函数  这个会报错
        Class<?>[] classTypes = new Class[]{String.class,String.class,Integer.class};
        Object[] objects = {"abc@qq.com","注册短信",6};
        SmsBody smsBody = (SmsBody)enhancer.create(classTypes,objects);
        smsBody.getTitle();
        //调用代理类的eat方法
        System.out.println("toString="+smsBody.toString());

    }

}
