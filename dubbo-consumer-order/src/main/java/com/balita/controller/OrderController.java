package com.balita.controller;

import com.belita.service.OrderService;
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
    public String getInfo(){
        log.info("dubbo测试....");
        return orderService.getInfo();
    }

}
