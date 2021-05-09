package com.belita.service.impl;

import com.belita.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public String getInfo() {
        log.info("node10-dubbo-server start ...");
        return "node10-dubbo-server";
    }

}
