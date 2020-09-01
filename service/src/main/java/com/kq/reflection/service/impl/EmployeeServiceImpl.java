package com.kq.reflection.service.impl;



import com.kq.reflection.entity.Employee;
import com.kq.reflection.service.EmployeeService;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2020-09-01 9:57
 * @since 2020-0630
 */
public class EmployeeServiceImpl implements EmployeeService {

    AtomicLong atomicLong = new AtomicLong();

    @Override
    public Long add(Employee e) {

        Long id = atomicLong.incrementAndGet();
        e.setId(id);
        System.out.println("添加员工成功! id="+e.getId());

        return e.getId();

    }
}
