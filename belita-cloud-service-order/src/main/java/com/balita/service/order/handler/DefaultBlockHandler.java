package com.balita.service.order.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultBlockHandler {

//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
//        log.info("sentinel的统一异常调用：msg = {}", e.getMessage());
//        e.printStackTrace();
//
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter writer = response.getWriter();
//
//        writer.write(JSONUtil.toJsonStr(JsonResult.error(e.getMessage())));
//    }

    /**
     * @Description: 普通阻塞错误
     * @param:
     * @return:
     * @author: fanjc
     * @Date: 2019/5/10
     */
    public static String exceptionHandler(BlockException e) {
        log.info("sentinel的统一异常调用：msg = {}，CanonicalName = {}", e.getMessage(), e.getClass().getCanonicalName());
        return "error:" + e.getMessage();
    }


}
