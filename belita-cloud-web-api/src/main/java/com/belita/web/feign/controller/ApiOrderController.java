package com.belita.web.feign.controller;

import com.beilita.common.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/web/order")
public class ApiOrderController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private OrderClient orderClient;


    @GetMapping("/findAll")
    public JsonResult findAll(){
        List forObject = restTemplate.getForObject("http://order-server/api/order/findAll", List.class);
        return JsonResult.success(forObject);
    }

//    @GetMapping("/findInfo")
//    public JsonResult findInfo(){
//        Map map = orderClient.findInfo();
//        return JsonResult.success(map);
//    }

}
