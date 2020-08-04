package com.github.devsjh.controller;

import com.github.devsjh.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final PostService postService;

    @RequestMapping(value = {"", "/"}, method = { RequestMethod.GET }) // 게시판 목록
    public ModelAndView board(@PageableDefault Pageable pageable, ModelAndView mv) {
        mv.addObject("postList", postService.getPostList(pageable));
        mv.setViewName("board");

        return mv;
    }

    @RequestMapping(value = "posts", method = { RequestMethod.GET }) // 게시판 목록
    public ModelAndView posts(@PageableDefault Pageable pageable, ModelAndView mv) {
        mv.addObject("postList", postService.getPostList(pageable));
        mv.setViewName("board");

        return mv;
    }

    @RequestMapping(value = "/posts/save", method = { RequestMethod.GET }) // 게시글 등록 폼
    public ModelAndView save(ModelAndView mv) {
        mv.setViewName("post/save");

        return mv;
    }

    @RequestMapping(value = "/posts/update/{id}", method = { RequestMethod.GET }) // 게시글 수정 폼
    public ModelAndView update(@PathVariable("id") Long id, ModelAndView mv) {
        mv.addObject("post", postService.getPost(id));
        mv.setViewName("post/update");

        return mv;
    }
}