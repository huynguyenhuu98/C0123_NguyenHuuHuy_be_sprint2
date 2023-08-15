package com.example.backend_sprint2.service;

import com.example.backend_sprint2.dto.ProductRacingDTO;
import com.example.backend_sprint2.model.ProductRacing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductRacingService {
    Page<ProductRacingDTO> getProductRacing(Pageable pageable, String nameSearch);
    ProductRacing findById(Long id);

}
