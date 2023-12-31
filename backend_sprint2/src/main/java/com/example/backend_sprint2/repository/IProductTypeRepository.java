package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType,Long> {
    @Query(value = "select * from product_type",nativeQuery = true)
    List<ProductType> findAllType();
}
