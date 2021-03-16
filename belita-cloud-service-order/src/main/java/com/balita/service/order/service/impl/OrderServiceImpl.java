package com.balita.service.order.service.impl;

import com.balita.service.order.entity.Order;
import com.balita.service.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> findAll() {
        String sql = "select * from tb_order where 1=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        //(sql, new Object[]{}, new BeanPropertyRowMapper<Order>(Order.class));
    }

    @Override
    public Order findInfo(Long id) {
        String sql = "select * from tb_order where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Order>(Order.class), id);
    }
}
