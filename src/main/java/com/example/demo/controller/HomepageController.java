package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomepageController {
	
	// 使用thymeleaf模板，返回时默认不需要加上.html
	
	@GetMapping("error")
	public String error() {
		return "error";
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
