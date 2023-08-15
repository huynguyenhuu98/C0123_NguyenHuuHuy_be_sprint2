package com.example.backend_sprint2.service;

import com.example.backend_sprint2.dto.PostsDTO;
import com.example.backend_sprint2.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostsService {
    Page<PostsDTO> getAllPosts (Pageable pageable, String nameSearch);
    Optional<Posts> findByIdPosts(Long id);
}
