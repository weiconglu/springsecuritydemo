package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("tb_t_book")
public class Book {

	@TableId(type = IdType.AUTO)
	private Integer id;
	private String title;
	private String author;
	private String description;
	private String isbn;

}
