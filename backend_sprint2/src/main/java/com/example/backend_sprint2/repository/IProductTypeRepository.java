package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType,Long> {
}
