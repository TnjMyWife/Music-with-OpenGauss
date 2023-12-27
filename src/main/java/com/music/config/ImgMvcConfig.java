package com.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //String filePath = "E:\\privat\\opt\\musicfile\\user_img\\";
        String filePath = "/opt/musicfile/user_img/";
        registry.addResourceHandler("/opt/musicfile/user_img/**").addResourceLocations("file:"+filePath);
    }
}
