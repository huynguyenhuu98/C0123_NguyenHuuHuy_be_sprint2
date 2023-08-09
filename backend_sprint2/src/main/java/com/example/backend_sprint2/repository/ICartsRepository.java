package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartsRepository extends JpaRepository<Carts,Long> {
}
