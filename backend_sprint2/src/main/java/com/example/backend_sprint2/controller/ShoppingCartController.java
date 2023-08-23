package com.example.backend_sprint2.controller;

import com.example.backend_sprint2.config.JwtTokenUtil;
import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.model.ProductRacing;
import com.example.backend_sprint2.model.Carts;
import com.example.backend_sprint2.service.ICustomersService;
import com.example.backend_sprint2.service.IProductRacingService;
import com.example.backend_sprint2.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ICartsService iCartsService;
    @Autowired
    private IProductRacingService iProductRacingService;
    @Autowired
    private ICustomersService iCustomersService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping()
    public ResponseEntity<List<Carts>> getAll() {
        List<Carts> shoppingCarts = iCartsService.findAll();
        return new ResponseEntity<>(shoppingCarts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(HttpServletRequest httpServletRequest,
                                 @RequestParam(value = "quantity") Integer quantity,
                                 @RequestParam(value = "idRacing") Long idRacing) {
        ProductRacing productRacing = iProductRacingService.findById(idRacing);
        String header = httpServletRequest.getHeader("Authorization");
        String token = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Customers customers = iCustomersService.findUsersId(username);
        if (quantity > 0) {
            Carts shoppingCart = iCartsService.findByCustomersProduct(customers, productRacing);
            if (shoppingCart != null) {
                Integer amount = shoppingCart.getQuantity() + quantity;
                shoppingCart.setQuantity(amount);
                iCartsService.add(shoppingCart);
                return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
            }
        }
        Carts shoppingCartNew = new Carts(quantity,customers,productRacing);
        iCartsService.add(shoppingCartNew);
        return new ResponseEntity<>(shoppingCartNew, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteShopping(@PathVariable("id") Long id) {
        iCartsService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{setQuantity}/{id}")
    public ResponseEntity<?> setQuantityCart(@PathVariable Integer setQuantity, @PathVariable Long id) {
        try {
            iCartsService.setQuantityShoppingCart(setQuantity, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}