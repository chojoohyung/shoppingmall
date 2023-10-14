package com.yuhan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	
	@Value("${uploadPath}")
	String uploadPath;
	
	/* 이미지 업로드 url 지정 -> img
	 * 8080/img/** 에 대한 접근 설정
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations(uploadPath);
	}
	
	/*
	 * index, main 컨트롤러
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
//		registry.addViewController("/").setViewName("main");
	}

}