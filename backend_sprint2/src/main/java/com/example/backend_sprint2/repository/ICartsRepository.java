package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Carts;
import com.example.backend_sprint2.model.Customers;
import com.example.backend_sprint2.model.ProductRacing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface ICartsRepository extends JpaRepository<Carts,Long> {
    Carts findByCustomersAndProductRacing(Customers customers, ProductRacing productRacing);
    @Query(value = "SELECT * FROM shopping_cart as p\n" +
            "INNER JOIN customers c on p.id_customers = c.id\n" +
            "WHERE p.id_customers=:id\n"
            , nativeQuery = true)
    List<Carts> findAllCustomers(Long id);


    @Transactional
    @Modifying
    void deleteShoppingCartByCustomers(Customers customers);
}
