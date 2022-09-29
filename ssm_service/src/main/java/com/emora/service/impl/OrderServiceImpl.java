package com.emora.service.impl;

import com.emora.domain.Orders;
import com.emora.mapper.OrderMapper;
import com.emora.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 10:58
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> findAll() {
        return orderMapper.findAllOrders();
    }

    @Override
    public void save(Orders orders) {

        orderMapper.save(orders);
    }
}
