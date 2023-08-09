package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.ProductRacing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRacingRepository extends JpaRepository<ProductRacing,Long> {
    @Query(value = "select * from product_racing p where name_racing like concat('%', :nameSearch, '%')", nativeQuery = true)
    Page<ProductRacing> findProductRacing(Pageable pageable, @Param("nameSearch") String nameSearch);
}
