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
