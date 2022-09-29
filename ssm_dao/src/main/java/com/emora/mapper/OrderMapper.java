package com.emora.mapper;

import com.emora.domain.Orders;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 11:04
 */
public interface OrderMapper {
    List<Orders> findAllOrders();

    void save(Orders orders);
}
