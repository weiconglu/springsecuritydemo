package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName("tb_t_user")
@Data
public class User {

	@TableId(type = IdType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private String authority;

}
