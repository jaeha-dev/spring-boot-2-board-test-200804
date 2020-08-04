package com.github.devsjh;

import com.github.devsjh.domain.Post;
import com.github.devsjh.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@SpringBootApplication
public class DevsjhApplication {

    private final PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(DevsjhApplication.class, args);
    }

    @Bean
    public CommandLineRunner initApplication() {
        // 초기 게시글을 생성한다.
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (long i = 0; i < 200; i++) {
                    Post post = Post.builder()
                            .id(i)
                            .title("테스트 제목" + i)
                            .content("테스트 내용" + i)
                            .createdDate(LocalDateTime.now())
                            .build();

                    postRepository.save(post);
                }
            }
        };
    }
}