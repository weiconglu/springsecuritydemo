package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/books")
public class BookControllerTraditional {

	@Autowired
	private BookMapper bookMapper;

	// http://127.0.0.1:8080/books/list

	@GetMapping("list")
	public String books(Model model) {
		List<Book> books = bookMapper.selectList(null);
		if (books != null && books.size() != 0) {
			model.addAttribute("books", books);
		}
		return "books";
	}

	/*
	 * 转到books.html处，更改action来测试接收参数 <h3>Add a book</h3> <form method="POST" action="add1">
	 */
	@ApiOperation("用实体接")
	@PostMapping("add1")
	public String add1(Book book) {
		System.out.println(book);
		Integer resultInteger = bookMapper.insert(book);
		if (resultInteger != 1) {
			System.out.println("保存失败");
		}
		return "redirect:/books/list";
	}

	/*
	 * 根据前端的设置不同，这种接收方式可能会报错
	 * 
	 * .w.s.m.s.DefaultHandlerExceptionResolver : Resolved
	 * [org.springframework.web.HttpMediaTypeNotSupportedException: Content type
	 * 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
	 */
	@ApiOperation("用@RequestBody Book book实体接")
	@PostMapping("add2")
	public String add2(@RequestBody Book book) {
		System.out.println(book);
		Integer resultInteger = bookMapper.insert(book);
		if (resultInteger != 1) {
			System.out.println("保存失败");
		}
		return "redirect:/books/list";
	}

	@ApiOperation("用String title,String author,String description,String isbn接")
	@PostMapping("add3")
	public String add3(String title, String author, String description, String isbn) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setIsbn(isbn);

		Integer resultInteger = bookMapper.insert(book);
		if (resultInteger != 1) {
			System.out.println("保存失败");
		}
		return "redirect:/books/list";
	}

}
