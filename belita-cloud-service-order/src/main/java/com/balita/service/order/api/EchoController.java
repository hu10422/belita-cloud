package com.balita.service.order.api;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


@RestController
@RefreshScope
public class EchoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("index")
    public String index(){
        return StrUtil.format("Hello Word![{}]", port);
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return StrUtil.format("Hello Nacos Discovery {}", port, string);
    }


}
