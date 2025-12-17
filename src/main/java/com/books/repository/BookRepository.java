package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
 
}
