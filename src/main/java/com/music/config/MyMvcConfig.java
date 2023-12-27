package com.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

        registry.addViewController("/homepage").setViewName("homepage");
        registry.addViewController("/homepage.html").setViewName("homepage");

        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/register.html").setViewName("register");

        registry.addViewController("/browserArtist").setViewName("browserArtist");
        registry.addViewController("/browserArtist.html").setViewName("browserArtist");

        registry.addViewController("/browserAlbum").setViewName("browserAlbum");
        registry.addViewController("/browserAlbum.html").setViewName("browserAlbum");

        registry.addViewController("/artistPage").setViewName("artistPage");
        registry.addViewController("/artistPage.html").setViewName("artistPage");

        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/user.html").setViewName("user");

        registry.addViewController("/song").setViewName("song");
        registry.addViewController("/song.html").setViewName("song");

        registry.addViewController("/listSong").setViewName("listSong");
        registry.addViewController("/listSong.html").setViewName("listSong");

        registry.addViewController("/albumpage").setViewName("albumpage");
        registry.addViewController("/albumpage.html").setViewName("albumpage");

        registry.addViewController("/searchPage").setViewName("searchPage");
        registry.addViewController("/searchPage.html").setViewName("searchPage");
    }
/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns
                ("/register" ,"/index", "/",
                "/user/login", "/user/regist",
                "/css/**", "/img/**", "/js/**", "/music/**", "/video/**");
    }
*/
}
