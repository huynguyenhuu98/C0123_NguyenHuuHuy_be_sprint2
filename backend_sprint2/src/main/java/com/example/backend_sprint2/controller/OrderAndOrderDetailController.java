package com.example.backend_sprint2.controller;

import com.example.backend_sprint2.config.JwtTokenUtil;
import com.example.backend_sprint2.model.Carts;
import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.model.Orders;
import com.example.backend_sprint2.model.OrdersDetail;
import com.example.backend_sprint2.service.ICartsService;
import com.example.backend_sprint2.service.ICustomersService;
import com.example.backend_sprint2.service.IOrdersDetailService;
import com.example.backend_sprint2.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/order/orderDetail")
@CrossOrigin("*")
public class OrderAndOrderDetailController {
    @Autowired
    private IOrdersService iOrdersService;
    @Autowired
    private ICartsService iCartsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ICustomersService iCustomerService;
    @Autowired
    private IOrdersDetailService iOrdersDetailService;
    @Transactional
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> saveOrderAndOrderDetail(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        String token = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Customers customers = iCustomerService.findUsersId(username);
        List<Carts> shoppingCartList = iCartsService. findAllByShopping(customers.getId());
        Long totalPrice = 0L;
        for (int i = 0; i < shoppingCartList.size(); i++) {
            totalPrice += shoppingCartList.get(i).getProductRacing().getPrice() * shoppingCartList.get(i).getQuantity();
        }
        Orders orders = new Orders(totalPrice, customers);
        iOrdersService.save(orders);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/history")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_ADMIN')")
    public ResponseEntity<List<Orders>> getAll(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("Authorization");
        String token = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Customers customers = iCustomerService.findUsersId(username);

        if (customers != null){
            List<Orders> ordersList = iOrdersService.findAll(customers.getId());
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/history/detail")
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER')")
    public ResponseEntity<List<OrdersDetail>> historyDetail(@RequestParam("id") Long id) {
        List<OrdersDetail> orders = iOrdersDetailService.findAllOrders(id);
        if (orders.isEmpty() && orders == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}



