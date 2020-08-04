package com.github.devsjh.service;

import com.github.devsjh.domain.Post;
import com.github.devsjh.exception.CustomResourceNotFoundException;
import com.github.devsjh.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepository postRepository;

    /**
     * 게시글 목록 조회
     */
    public Page<Post> getPostList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("id").descending()
        );

        return postRepository.findAll(pageable);
    }

    /**
     * 게시글 1건 조회
     */
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(CustomResourceNotFoundException::new);
    }

    /**
     * 게시글 등록
     */
    @Transactional
    public Post savePost(Post post) {
        post.setCreatedDate(LocalDateTime.now());

        return postRepository.save(post);
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Post updatePost(Long id, Map<String, Object> param) {
        Post post = getPost(id);
        post.setTitle(param.get("title").toString());
        post.setContent(param.get("content").toString());

        return post.update(post);
    }

    /**
     * 게시글 삭제
     */
    @Transactional
    public Post deletePost(Long id) {
        Post post = getPost(id);
        postRepository.delete(post);

        return post;
    }
}