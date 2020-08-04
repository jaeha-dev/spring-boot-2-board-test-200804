package com.github.devsjh.repository;

import com.github.devsjh.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 게시글 1건 조회
    Optional<Post> findById(Long id);

    // 게시글 목록 페이징
    // Page<Post> findAll(Pageable pageable);
}