package com.balita.service.order.service;

import com.balita.service.order.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * 查询所有订单
     * @return
     */
    List<Order> findAll();

    Order findInfo(Long id);
}
