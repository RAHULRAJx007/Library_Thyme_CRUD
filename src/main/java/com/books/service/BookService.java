package com.books.service;


import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.model.Book;
import com.books.repository.BookRepository;

@Service
public class BookService {
	@Autowired BookRepository repo;
	
		public Boolean save(Book book) {
			try {
					repo.save(book);	
					return true;
			}
			catch(Exception e) {
				return false;
			}
	}

		public List<Book> getAllBooks() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}

		public @Nullable Object findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		public Book getBookById(int id) {
			
			return repo.findById(id).orElse(null);
		}


}
