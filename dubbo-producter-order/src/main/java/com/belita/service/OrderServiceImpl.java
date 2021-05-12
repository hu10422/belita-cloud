package com.belita.service;

import com.belita.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public String getInfo() {
        return "dubbo-producter-order";
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    @Override
    public Order getOrder(Long id) {
        if (id % 2 == 0) {
            throw new RuntimeException("测试用的异常");
        }

        Order order = new Order();
        order.setId(id);
        order.setRemark("模拟实例");
        return order;
    }

    @Override
    public Order timeOrder(Long id, Long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        return this.getOrder(id);
    }
}
