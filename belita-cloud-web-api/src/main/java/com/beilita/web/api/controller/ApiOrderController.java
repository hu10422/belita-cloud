package com.beilita.web.api.controller;

import com.beilita.common.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/web/order")
public class ApiOrderController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/findAll")
    public JsonResult findAll(){
        JsonResult forObject = restTemplate.getForObject("http://order/api/order/findAll", JsonResult.class);
        return forObject;
    }

}
