package com.kq.cglib.demo;

import com.kq.cglib.interceptor.TransactionInterceptor;
import com.kq.reflection.entity.Employee;
import com.kq.reflection.service.EmployeeService;
import com.kq.reflection.service.impl.EmployeeServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author kq
 * @date 2020-09-01 11:10
 * @since 2020-0630
 */
public class EmployeeServiceCglibDemo {

    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java\\java_workapace");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(EmployeeServiceImpl.class);
        //设置回调函数
        enhancer.setCallback(new TransactionInterceptor());

        //这里的creat方法就是正式创建代理类
//        EmployeeServiceImpl employeeServiceProxy = (EmployeeServiceImpl)enhancer.create();
        EmployeeService employeeServiceProxy = (EmployeeServiceImpl)enhancer.create();
        //调用代理类的eat方法
        Employee employee = new Employee();
        Long id = employeeServiceProxy.add(employee);
        System.out.println("id="+id);
    }

}
