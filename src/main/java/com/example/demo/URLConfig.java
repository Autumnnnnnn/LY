package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 图片绝对地址与虚拟地址映射
 */

@Configuration
public class URLConfig implements WebMvcConfigurer {

    @Value("${invented.img}")
    private String inventedImg;
    @Value("${url.trueLocation}")
    private String trueLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler(inventedImg).addResourceLocations(trueLocation);
//        registry.addResourceHandler("/video/view/**").addResourceLocations("file:/E:/video/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
