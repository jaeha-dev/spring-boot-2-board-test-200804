package com.github.devsjh.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "createdDate", nullable = false)
    private LocalDateTime createdDate;

    /**
     * 게시글 수정
     * (setter 메소드를 통한 값 변경만으로도 가능하다.)
     */
    public Post update(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        return this;
    }

    /**
     * 게시글 수정 (Map 활용)
     */
    public Post update(Map<String, Object> param) {
        this.title = param.get("title").toString();
        this.content = param.get("content").toString();

        return this;
    }
}