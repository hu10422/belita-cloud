package com.belita.web.feign.controller;

import cn.hutool.core.date.TimeInterval;
import com.beilita.common.result.JsonResult;
import com.belita.web.feign.service.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderClient orderClient;


    @GetMapping("feign/fingInfo")
    public JsonResult fingInfo(Long id) {
        TimeInterval interval = new TimeInterval();
        Map info = orderClient.findInfo(id);
        log.info("查询数据，耗时{}毫秒", interval.interval());
        return JsonResult.success(info);
    }
}
