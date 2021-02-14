//package com.example.demo.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.example.demo.mapper.UserMapper;
//import com.example.demo.model.User;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserMapper userMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		// 使用MP条件构造器来查询或者map来查询
//		User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
//		if (user == null || !username.equals(user.getUsername())) { // <------加入区分用户名大小写逻辑
//			throw new UsernameNotFoundException("用户" + username + "不存在");
//		}
//
//		System.out.println(user);
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//				.commaSeparatedStringToAuthorityList(user.getAuthority());
//
//		org.springframework.security.core.userdetails.User returnUser = new org.springframework.security.core.userdetails.User(
//				username, new BCryptPasswordEncoder().encode(user.getPassword()), grantedAuthorities);
//		System.out.println(returnUser);
//
//		return returnUser;
//	}
//
//}
