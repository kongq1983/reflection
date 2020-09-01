package com.kq.service.impl;

import com.kq.java.entity.Product;
import com.kq.service.ProductService;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2020-09-01 9:57
 * @since 2020-0630
 */
public class ProductServiceImpl implements ProductService {

    AtomicLong atomicLong = new AtomicLong();

    @Override
    public Product add(Product e) {

        Long id = atomicLong.incrementAndGet();
        e.setId(id);
        System.out.println("添加产品成功! id="+e.getId());

        return e;

    }
}
