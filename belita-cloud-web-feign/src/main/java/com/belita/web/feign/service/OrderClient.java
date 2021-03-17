package com.belita.web.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(name = "order-server")
public interface OrderClient {


   /* 一般我们会使用@GetMapping和@PostMapping两种方式来调用Rest服务。
    而接收的参数则会使用@RequestParam和@RequestBody来获取。
    首先我们讲一下@RequestBody，@RequestBody只能用在Post请求，并且一个Post请求只能有一个@RequestBody。 @RequestBody的参数可以包括复杂类型。
    然后我们讲一下@RequestParam，@RequestParam可以用在Post和Get请求中，但是要注意：@RequestParam 的参数只能是基本类型或者Enum，或者List和Map（List和Map里面也只能是基本类型）。所以@RequestParam可以和@RequestBody一起使用。
    如果我们是Get请求，但是又有复合类型怎么办？ 比如我们想传递一个User对象。User对象里面只有普通的两个String属性。 这里我们可以使用@SpringQueryMap：
    注意：@SpringQueryMap后面的参数只能是普通的POJO，不能是复合类型，否则解析不了。如果必须使用复合类型，那么使用@RequestBody吧。
    */

    /**
     * {@literal https://zhuanlan.zhihu.com/p/133378040}
     * @param id
     * @return
     */
    @GetMapping("/api/order/findInfo")
    Map findInfo(@RequestParam("id") Long id);
}
