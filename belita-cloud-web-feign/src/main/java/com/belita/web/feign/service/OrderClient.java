package com.belita.web.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "order-server")
public interface OrderClient {

    @RequestMapping("/api/order/findInfo")
    Map findInfo(Long id);
}
