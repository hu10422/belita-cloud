package com.balita.service.order.api;

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
        return "Hello Word!" + port;
    }


    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }


}
