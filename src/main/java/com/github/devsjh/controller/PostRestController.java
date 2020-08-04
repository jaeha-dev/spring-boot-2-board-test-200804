package com.github.devsjh.controller;

import com.github.devsjh.domain.Post;
import com.github.devsjh.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostRestController {

    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    /**
     * 게시글 상세 조회
     * /api/posts/{id}
     */
    @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
        logger.info("getPost()");

        Post post = postService.getPost(id);

        return new ResponseEntity<>(post, HttpStatus.OK);
        // return ResponseEntity.ok(post);
    }

    /**
     * 게시글 등록
     * /api/posts
     */
    @RequestMapping(value = "", method = { RequestMethod.POST })
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        logger.info("savePost()");

        return new ResponseEntity<>(postService.savePost(post), HttpStatus.OK);
    }

    /**
     * 게시글 수정 (@RequestBody: Map)
     * /api/posts/{id}
     */
    @RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Map<String, Object> param) {
        logger.info("updatePost()");

        return new ResponseEntity<>(postService.updatePost(id, param), HttpStatus.OK);
    }

    /**
     * 게시글 삭제
     * /api/posts/{id}
     */
    @RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id) {
        logger.info("deletePost()");

        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }
}
