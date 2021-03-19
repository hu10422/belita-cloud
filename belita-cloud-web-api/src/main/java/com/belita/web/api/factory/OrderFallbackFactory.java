package com.belita.web.api.factory;

import com.belita.web.api.service.OrderClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class OrderFallbackFactory implements FallbackFactory<OrderClient> {

    @Override
    public OrderClient create(Throwable cause) {
        log.error("订单服务异常：msg={}",cause.getMessage());
        return new OrderClient() {
            @Override
            public Map findInfo(Long id) {
                log.error("openFeign fallback findInfo");
                return null;
            }

            @Override
            public String index() {
                log.error("openFeign fallback index");
                return null;
            }
        };
    }
}
