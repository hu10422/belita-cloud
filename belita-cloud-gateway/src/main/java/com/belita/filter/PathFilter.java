//package com.belita.filter;
//
//
//import cn.hutool.json.JSON;
//import cn.hutool.json.JSONUtil;
//import com.beilita.common.result.JsonResult;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.io.buffer.DataBufferFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Component
//public class PathFilter implements GlobalFilter {
//
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        String path = exchange.getRequest().getURI().getPath();
//
//
//
//        return null;
//    }
//
//    private Mono<Void> setPathesponse(ServerWebExchange exchange, String msg)
//    {
//        ServerHttpResponse response = exchange.getResponse();
//        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//        response.setStatusCode(HttpStatus.OK);
//
//        log.error("[鉴权异常处理]请求路径:{}", exchange.getRequest().getPath());
//
//        return response.writeWith(Mono.fromSupplier(() -> {
//            DataBufferFactory bufferFactory = response.bufferFactory();
//            return bufferFactory.wrap(JSON.toJSONBytes(JsonResult.error(msg)));
//        }));
//    }
//
//}
