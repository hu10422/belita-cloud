package com.belita.web.api.controller;

import com.beilita.common.result.JsonResult;
import com.belita.web.api.service.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/web/order")
public class ApiOrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderClient orderClient;


    @GetMapping("/findAll")
    public JsonResult findAll(){
        List forObject = restTemplate.getForObject("http://order-server/api/order/findAll", List.class);

        return JsonResult.success(forObject);
    }

    @GetMapping("/index")
    public JsonResult index() {
        return JsonResult.success(orderClient.index());
    }

    @GetMapping("/findInfo")
    public JsonResult findInfo(Long id){
        Map map = orderClient.findInfo(id);
        if (map == null || map.isEmpty()) {
            throw new RuntimeException("没有查到ID的数据");
        }
        return JsonResult.success(map);
    }

}
