//package com.example.demo.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	/**
//	 * 使用Spring security的Remember me功能，注入数据库操作对象
//	 * 
//	 * @return
//	 */
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
//		jdbcTokenRepositoryImpl.setDataSource(dataSource);
////		jdbcTokenRepositoryImpl.setCreateTableOnStartup(true); // <------ 这里设置为false，不让spring security自动建表，将建表操作配置到application.properties中
//		return jdbcTokenRepositoryImpl;
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		// 自定义无权访问页面
//		http.exceptionHandling().accessDeniedPage("/permission_denied");
//		
//		// 在登录成功界面加上个登出
//		http.logout()
//				.logoutUrl("/logout") // <------ 这里是个访问路径，前端页面提交的地址是<a href="/springbootaction/logout">退出</a>
//				.logoutSuccessUrl("/logout_success").permitAll();
//		
//		http.formLogin() // <------自定义登录页面设置
//				.loginPage("/verify") // <------ 登录页面的请求路径，都统一都写请求路径，让controller去跳转，不要写放在static下面的静态页面，容易混乱
//				/*
//				 * 验证传回的用户名密码的请求路径，由spring security自己生成，
//				 * 与verify.html 页面相对登录验证提交的地址相对应-> <form action="/springbootaction/login_verify" method="post">
//				 * 这个请求路径要在.antMatchers("/login_verify","/hello").permitAll()打开
//				 */
//				.loginProcessingUrl("/login_verify") // <------ spring security自动生成此访问路径
//				.defaultSuccessUrl("/login_success").permitAll() // <------ 登录成功后跳转路径
//				.and().authorizeRequests() // <----- 用来设置设置不需要登录就可以访问的路径
//				.antMatchers("/login_verify","/hello","/swagger-resources/**", "/webjars/**", "/v2/**", "/api-docs/**", "/swagger-ui.html/**").permitAll()
//				.antMatchers("/books/**").hasAuthority("root") // <------有root角色权限的才可以访问
//				.antMatchers("/readme").hasAnyAuthority("root","guest") // <------有root或guest角色权限的就可以访问
////				.antMatchers("").hasRole("admin") // 不再演示，注意处理role前要在查询出来的角色前加上ROLE_
////				.antMatchers("").hasAnyRole("guest")
//				.anyRequest().authenticated()
//				.and().rememberMe() // <------ 开启记住我功能，在verify.html中加入<input type="checkbox" name="remember-me">保持登录注意其name必须为remember-me
//				.tokenRepository(persistentTokenRepository()) // <------指定操作数据库的jdbcTokenRepositoryImpl
//				.tokenValiditySeconds(60) // <------设置token有效时长，其内部使用的是UTC时间
//				.userDetailsService(userDetailsService) // <------ 操作用户表的com.example.demo.service.impl.UserDetailsServiceImpl实例
//				.and().csrf().disable(); // <------ 关闭csrf防护，默认会开启，这里不演示了
//	}
//
//}
