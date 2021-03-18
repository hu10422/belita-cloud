package com.belita.web.api.controller;

import com.beilita.common.result.JsonResult;
import com.belita.web.api.service.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 通过@RefreshScope 获取nacos config 配置
//@RefreshScope
@RestController
public class IndexController {


    @Autowired
    private OrderClient orderClient;

    @GetMapping("/index")
    public JsonResult index() {

        return JsonResult.success(orderClient.index());
    }


}
