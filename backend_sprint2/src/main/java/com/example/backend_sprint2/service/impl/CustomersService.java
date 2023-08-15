package com.example.backend_sprint2.service.impl;

import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.repository.ICustomersRepository;
import com.example.backend_sprint2.service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService implements ICustomersService {
    @Autowired
    private ICustomersRepository iCustomersRepository;


    @Override
    public Customers findUsersId(String username) {
        return iCustomersRepository.findUsers(username);
    }
}
