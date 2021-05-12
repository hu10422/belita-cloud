package com.balita.controller;

import com.belita.model.Order;
import com.belita.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @DubboReference
    private OrderService orderService;

    @GetMapping("/getInfo")
    public String getInfo() {
        log.info("dubbo测试....");
        return orderService.getInfo();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @GetMapping("/getOrder")
    public Order getOrder(Long id) {
        log.info("getOrder:id={}", id);
        return orderService.getOrder(id);
    }

    public Order reliable(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setRemark("异常模板实例");
        return order;
    }


}
