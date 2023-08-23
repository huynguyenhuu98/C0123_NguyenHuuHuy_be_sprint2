package com.example.backend_sprint2.service;

import com.example.backend_sprint2.dto.ProductRacingDTO;
import com.example.backend_sprint2.model.Posts;
import com.example.backend_sprint2.model.ProductRacing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductRacingService {
    Page<ProductRacingDTO> getProductRacing(Pageable pageable, String nameSearch);
    ProductRacing findById(Long id);
    Optional<ProductRacing> findByIdProduct(Long id);

}
