package com.belita.web.api.controller;

import com.belita.web.api.service.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// 通过@RefreshScope 获取nacos config 配置
//@RefreshScope
@RestController
public class IndexController {


    @Autowired
    private OrderClient orderClient;




}
