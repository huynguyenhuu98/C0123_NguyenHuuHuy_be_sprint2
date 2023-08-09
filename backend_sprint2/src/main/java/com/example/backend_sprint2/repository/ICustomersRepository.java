package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomersRepository extends JpaRepository<Customers,Long> {
}
