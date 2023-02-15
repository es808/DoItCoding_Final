package com.example.finalpro.dao;

import com.example.finalpro.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {
}
