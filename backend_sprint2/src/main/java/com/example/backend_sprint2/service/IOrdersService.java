package com.example.backend_sprint2.service;

import com.example.backend_sprint2.model.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(Long id);
    void  save(Orders orders);
}
