package com.kq.java.demo;

import com.kq.java.dynamic.EmployeeProxyHandler;
import com.kq.java.entity.Employee;
import com.kq.service.EmployeeService;
import com.kq.service.impl.EmployeeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author kq
 * @date 2020-09-01 10:11
 * @since 2020-0630
 */
public class EmployeeProxyHandlerDemo {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        Employee employee = new Employee();

        InvocationHandler handler = new EmployeeProxyHandler(employeeService);

        EmployeeService employeeServiceProxy = (EmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(), employeeService.getClass().getInterfaces(), handler);

        Long id = employeeServiceProxy.add(employee);
        System.out.println("id="+id);
    }

}
