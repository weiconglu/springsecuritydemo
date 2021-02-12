package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("URL------>" + request.getRequestURL());

//		String appKey = request.getHeader("AppKey");
//		if (null == appKey || !appKey.equals("demo")) { // <------ 拦截AppKey不正确的请求
//			System.out.println("ATTENTION: AppKey不正确，请求被系统拦截");
//			response.sendRedirect("https://www.baidu.com");
//			return false;
//		}

		return true;
	}

}
