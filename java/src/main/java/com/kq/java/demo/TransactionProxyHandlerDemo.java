package com.kq.java.demo;

import com.kq.java.dynamic.EmployeeProxyHandler;
import com.kq.java.dynamic.TransactionProxyHandler;
import com.kq.java.entity.Employee;
import com.kq.java.entity.Product;
import com.kq.service.EmployeeService;
import com.kq.service.ProductService;
import com.kq.service.impl.EmployeeServiceImpl;
import com.kq.service.impl.ProductServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author kq
 * @date 2020-09-01 10:32
 * @since 2020-0630
 */
public class TransactionProxyHandlerDemo {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = new Employee();
        TransactionProxyHandler handler = new TransactionProxyHandler(employeeService);
        EmployeeService employeeServiceProxy = (EmployeeService)handler.getProxy();
        Long id = employeeServiceProxy.add(employee);
        System.out.println("id="+id);

        ProductService productService = new ProductServiceImpl();
        Product product = new Product();
        TransactionProxyHandler proxyHandler = new TransactionProxyHandler(productService);
        ProductService productServiceProxy = (ProductService)proxyHandler.getProxy();
        Product result = productServiceProxy.add(product);
        System.out.println("Product result ="+result);

    }

}
