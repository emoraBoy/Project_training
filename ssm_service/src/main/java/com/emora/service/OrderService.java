package com.emora.service;

import com.emora.domain.Orders;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 10:52
 */
public interface OrderService {
    List<Orders> findAll();

    void save(Orders orders);
}
