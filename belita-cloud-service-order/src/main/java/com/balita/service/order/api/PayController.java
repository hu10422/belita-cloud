package com.balita.service.order.api;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.balita.service.order.handler.DefaultBlockHandler;
import com.balita.service.order.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @SentinelResource(value = "order_forGet", blockHandler = "exceptionHandler", blockHandlerClass = {DefaultBlockHandler.class})
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
//    exceptionsToIgnore = {IllegalArgumentException.class})
    @GetMapping("/forGet")
    public String forGet() {
        return payService.forGet();
    }

    //    @SentinelResource(value = "order_forError", blockHandler = "exceptionHandler")
    @GetMapping("/forError")
    public String forError() {
        return payService.forError();
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(BlockException ex) {
        ex.printStackTrace();
        return "blockHandler:" + ex.getMessage();
    }
}
