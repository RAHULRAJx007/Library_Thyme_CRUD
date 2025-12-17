package com.books.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.books.model.Book;
import com.books.service.BookService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/")
	public String book_form(final Model model) {
		model.addAttribute("book", new Book());
		return "book_form";
	}
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Book book,Model model,BindingResult result ,@RequestParam("imageFile")MultipartFile file) throws IOException {
		
		if(result.hasErrors()) {
			return "book_form";
		}
		
		book.setFilename(file.getOriginalFilename());
		book.setImg(file.getBytes());
		
		Boolean check = service.save(book);
		if(check) {
			model.addAttribute("success","You are good to go!");
		}else {
			model.addAttribute("failed","No entry here!");
		}
		return "book_form";
	}
	@GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = service.getAllBooks();
        model.addAttribute("books", books);
        return "book_list"; 
    }
	@GetMapping("/updatebook/{id}")
	public String update(@PathVariable int id, Model model) {
		Book book = service.getBookById(id);
		model.addAttribute("edit", book);
		return "updatebook";
	}
	@PostMapping("/updatebook/{id}")
	 public String updateBook(@ModelAttribute Book book) {
        service.save(book);
        return "redirect:/list";
    }

//	@GetMapping("/cookieform")
//	public String form() {
//		return "cookieform";
//	}
//	
//	@GetMapping("/username")
//	public String setCookie(HttpServletResponse response,@RequestParam("username") String username) {
//		Cookie cookie = new Cookie("username",username);
//		cookie.setMaxAge(60*60);
//		cookie.setPath("/");
//		response.addCookie(cookie);
//		return "updateusername";
//	}
//	@GetMapping("/mycookie")
//	public String readCookie(@CookieValue(value = "username") String username, Model model) {
//		model.addAttribute("username",username);
//		return "hello";
//	}
}
