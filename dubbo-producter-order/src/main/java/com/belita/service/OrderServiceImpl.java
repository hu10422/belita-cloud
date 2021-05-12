package com.belita.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class OrderServiceImpl implements OrderService {

    @Override
    public String getInfo() {
        return "dubbo-producter-order";
    }
}
