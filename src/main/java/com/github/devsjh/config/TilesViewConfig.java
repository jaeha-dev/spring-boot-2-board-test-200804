package com.github.devsjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesViewConfig {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();

        // 타일즈 설정 파일
        configurer.setDefinitions("/WEB-INF/tiles/config.xml");

        // Refresh 옵션
        configurer.setCheckRefresh(true);

        return configurer;
    }

    @Bean
    public UrlBasedViewResolver tilesViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();

        // 타일즈 뷰 클래스 및 우선 순위 지정
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(1);

        return resolver;
    }
}
