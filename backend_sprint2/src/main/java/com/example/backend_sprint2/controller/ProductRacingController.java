package com.example.backend_sprint2.controller;

import com.example.backend_sprint2.dto.ProductRacingDTO;
import com.example.backend_sprint2.service.IProductRacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductRacingController {
    @Autowired
    private IProductRacingService iProductRacingService;
    @GetMapping("")
    public ResponseEntity<Page<ProductRacingDTO>> getProductRacing(@PageableDefault(sort = "name_racing", direction = Sort.Direction.DESC) Pageable pageable,
                                                           @RequestParam(required = false, defaultValue = "") String nameSearch) {
        Page<ProductRacingDTO> productRacingDTOPage = iProductRacingService.getProductRacing(pageable, nameSearch);
        if (productRacingDTOPage.isEmpty() && productRacingDTOPage == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productRacingDTOPage, HttpStatus.OK);
    }

}
