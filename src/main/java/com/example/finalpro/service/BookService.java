package com.example.finalpro.service;

import com.example.finalpro.dao.BookDAO;
import com.example.finalpro.entity.Book;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class BookService {
    @Autowired
    private BookDAO dao;

    public List<Book> findAll(){return dao.findAll();}
}
