package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String user);
}