package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	/*
	 * 使用thymeleaf模板，前缀和后缀已在配置文件中自动配置
	 * org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties
	 * public static final String DEFAULT_PREFIX = "classpath:/templates/";
	 * public static final String DEFAULT_SUFFIX = ".html";
	 */

	@GetMapping("verify")
	public String verify() {
		return "verify";
	}

	@GetMapping("error")
	public String error() {
		return "error";
	}

	@GetMapping("permission_denied")
	public String permissionDenied() {
		return "permission_denied";
	}

	@GetMapping("hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("readme")
	public String readme() {
		return "readme";
	}

	@GetMapping("login_success")
	public String login_success() {
		return "login_success";
	}

	@GetMapping("logout_success")
	public String logout_success() {
		return "logout_success";
	}

}
