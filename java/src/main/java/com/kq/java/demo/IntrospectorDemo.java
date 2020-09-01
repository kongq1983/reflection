package com.kq.java.demo;

import com.kq.java.entity.Employee;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author kq
 * @date 2020-09-01 9:38
 * @since 2020-0630
 */
public class IntrospectorDemo {

    public static void main(String[] args) throws Exception{
        Employee employee = new Employee();
        String property = "username";
        setProperty(employee,property);
        getProperty(employee,property);
    }

    // setUsername
    public static void setProperty(Employee employee, String userName) throws Exception {
        // 获取bean信息
        BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
        // 获取bean的所有属性列表
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        // 遍历属性列表，查找指定的属性
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                // 找到则写入属性值
                if (propDesc.getName().equals(userName)) {
                    Method method = propDesc.getWriteMethod();
                    System.out.println(userName+" setMethod="+method.toString());
                    method.invoke(employee, "admin");
                    System.out.println("set username:" + employee.getUsername());
                    break;
                }
            }
        }
    }

    // getUername
    public static void getProperty(Employee employee, String userName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
        if (proDescrtptors != null && proDescrtptors.length > 0) {
            for (PropertyDescriptor propDesc : proDescrtptors) {
                if (propDesc.getName().equals(userName)) {
                    Method method = propDesc.getReadMethod();
                    System.out.println(userName+" getMethod="+method.toString());
                    Object result = method.invoke(employee);
                    System.out.println("get username:" + result.toString());
                    break;
                }
            }
        }
    }

}
