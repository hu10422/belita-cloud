package com.belita.service;

import com.belita.model.Order;

public interface OrderService {

    String getInfo();

    Order getOrder(Long id);

    Order timeOrder(Long id, Long timeout);
}
