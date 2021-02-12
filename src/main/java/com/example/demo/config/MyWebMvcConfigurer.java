package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.MyInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
//		interceptorRegistration.addPathPatterns("/**"); // <------ 默认拦截所有路径，这里不写也可以
//		interceptorRegistration.excludePathPatterns("","/login");
		System.out.println("-------------interceptorRegistration--------------->"+interceptorRegistration);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
