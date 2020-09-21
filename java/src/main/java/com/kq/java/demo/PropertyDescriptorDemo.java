package com.kq.java.demo;


import com.kq.reflection.entity.Employee;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author kq
 * @date 2020-09-01 9:30
 * @since 2020-0630
 */
public class PropertyDescriptorDemo {

    public static void main(String[] args) throws Exception{
        Employee employee = new Employee();
        String property = "username";
        setProperty(employee,property);
        getProperty(employee,property);
    }

    public static void setProperty(Employee employee, String userName) throws Exception {
        // 获取bean的某个Set属性的描述符
        PropertyDescriptor propDesc = new PropertyDescriptor(userName, Employee.class);
        // 获得用于写入属性值的方法
        Method setMethod = propDesc.getWriteMethod();
        System.out.println(userName+" setMethod="+setMethod.toString());
        // 写入属性值
        setMethod.invoke(employee, "admin");
        System.out.println("set userName:" + employee.getUsername());
    }

    // 获取bean的某个Get属性值
    public static void getProperty(Employee employee, String userName) throws Exception {
        // 获取Bean的某个属性的描述符
        PropertyDescriptor proDescriptor = new PropertyDescriptor(userName, Employee.class);
        // 获得用于读取属性值的方法
        Method getMethod = proDescriptor.getReadMethod();
        System.out.println(userName+" getMethod="+getMethod.toString());
        // 读取属性值
        Object objUserName = getMethod.invoke(employee);
        System.out.println("get userName:" + objUserName.toString());
    }

}
