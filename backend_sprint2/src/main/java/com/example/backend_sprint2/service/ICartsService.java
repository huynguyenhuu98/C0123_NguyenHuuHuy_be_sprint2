package com.example.backend_sprint2.service;

import com.example.backend_sprint2.model.Carts;
import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.model.ProductRacing;

import java.util.List;

public interface ICartsService {
    void add(Carts shoppingCart);

    void remove(Long id);

    List<Carts> findAll();
    List<Carts> findAllByShopping(Long id);

    Carts findByCustomersProduct(Customers customers, ProductRacing productRacing);

    void setQuantityShoppingCart(Integer quantity, Long id);
}

