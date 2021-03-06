package com.balita.service.order.api;

import com.balita.service.order.entity.Order;
import com.balita.service.order.service.OrderService;
import com.beilita.common.util.TimeInterval;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/findAll")
    public List<Order> findAll() {
        TimeInterval interval = new TimeInterval();

        List<Order> all = orderService.findAll();
        log.info("查询所有订单,耗时[{}]毫秒", interval.interval());
        return all;
    }

    @GetMapping("/findInfo")
    public Order findInfo(@RequestParam("id") Long id) {
        TimeInterval interval = new TimeInterval();

        Order info = orderService.findInfo(id);
        log.info("查询所有订单,耗时[{}]毫秒", interval.interval());
        return info;
    }


}
