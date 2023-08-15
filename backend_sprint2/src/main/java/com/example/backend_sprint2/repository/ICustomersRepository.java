package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomersRepository extends JpaRepository<Customers,Long> {
    @Query(value = "SELECT * from customers as c\n" +
            "        INNER JOIN users u on u.id = c.users_id\n" +
            "         WHERE u.user_name=:name", nativeQuery = true)
    Customers findUsers(@Param("name")String name);

}
