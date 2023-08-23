package com.example.backend_sprint2.service.impl;

import com.example.backend_sprint2.dto.ProductRacingDTO;
import com.example.backend_sprint2.model.ProductRacing;
import com.example.backend_sprint2.repository.IProductRacingRepository;
import com.example.backend_sprint2.service.IProductRacingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductRacingService implements IProductRacingService {
    @Autowired
    private IProductRacingRepository iProductRacingRepository;

    @Override
    public Page<ProductRacingDTO> getProductRacing(Pageable pageable, String nameSearch) {
        List<ProductRacingDTO> productRacingDTOS = new ArrayList<>();
        Page<ProductRacing> productRacingPage = iProductRacingRepository.findProductRacing(pageable, nameSearch);
        ProductRacingDTO productRacingDTO;
        for (ProductRacing productRacing : productRacingPage) {
            productRacingDTO = new ProductRacingDTO();
            BeanUtils.copyProperties(productRacing, productRacingDTO);
            productRacingDTOS.add(productRacingDTO);
        }
        return new PageImpl<>(productRacingDTOS, pageable, productRacingPage.getTotalElements());
    }

    @Override
    public ProductRacing findById(Long id) {
        return iProductRacingRepository.findById(id).get();
    }

    @Override
    public Optional<ProductRacing> findByIdProduct(Long id) {
        return iProductRacingRepository.findById(id);
    }
}
