package com.balita.service.order.service.impl;

import com.balita.service.order.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {


    @Override
    public String forGet() {
        return "forGet";
    }

    @Override
    public String forError() {
        int i = 1 / 0;
        return "forError";
    }
}
