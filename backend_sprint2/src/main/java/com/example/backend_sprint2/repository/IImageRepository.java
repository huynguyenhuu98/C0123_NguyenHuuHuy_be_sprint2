package com.example.backend_sprint2.repository;

import com.example.backend_sprint2.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image,Integer> {
}
