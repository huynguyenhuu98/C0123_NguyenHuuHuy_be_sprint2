package com.example.backend_sprint2.service.impl;

import com.example.backend_sprint2.model.Carts;
import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.model.ProductRacing;
import com.example.backend_sprint2.repository.ICartsRepository;
import com.example.backend_sprint2.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsService implements ICartsService {
    @Autowired
    private ICartsRepository iCartsRepository;

    @Override
    public void add(Carts shoppingCart) {
        iCartsRepository.save(shoppingCart);
    }

    @Override
    public void remove(Long id) {
        iCartsRepository.deleteById(id);
    }

    @Override
    public List<Carts> findAll() {
        return iCartsRepository.findAll();
    }

    @Override
    public Carts findByCustomersProduct(Customers customers, ProductRacing product) {
        return iCartsRepository.findByCustomerProduct(customers,product);
    }

    @Override
    public void setQuantityShoppingCart(Integer quantity, Long id) {
        Carts carts=iCartsRepository.findById(id).get();
        if (quantity==0){
            carts.setQuantity(carts.getQuantity()-1);
            iCartsRepository.save(carts);
        }else {
            carts.setQuantity(carts.getQuantity()+1);
            iCartsRepository.save(carts);
        }
    }
}
