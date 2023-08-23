package com.example.backend_sprint2.service.impl;

import com.example.backend_sprint2.model.Orders;
import com.example.backend_sprint2.repository.IOrdersRepository;
import com.example.backend_sprint2.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {
    @Autowired
    private IOrdersRepository iOrdersRepository;

    @Override
    public void save(Orders orders) {
        iOrdersRepository.save(orders);
    }
    @Override
    public List<Orders> findAll(Long id) {
        return iOrdersRepository.findAll(id);
    }
}
