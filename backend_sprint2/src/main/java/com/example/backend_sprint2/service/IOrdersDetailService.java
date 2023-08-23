package com.example.backend_sprint2.service;

import com.example.backend_sprint2.model.OrdersDetail;

import java.util.List;

public interface IOrdersDetailService {
    void save(OrdersDetail ordersDetail);
    List<OrdersDetail> findAllOrders (Long id);
    List<OrdersDetail> findAllOrdersDetail(Long id);
}
