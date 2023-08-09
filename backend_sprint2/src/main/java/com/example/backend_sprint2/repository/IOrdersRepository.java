package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders,Long> {
}
