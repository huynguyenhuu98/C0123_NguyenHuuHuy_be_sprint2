package com.example.backend_sprint2.service;

import com.example.backend_sprint2.model.Customers;

public interface ICustomersService {
    Customers findUsersId(String username);
}
