package com.example.finalpro.service;

import com.example.finalpro.dao.TestDAO;
import com.example.finalpro.entity.Category;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class TestService {

    @Autowired
    private TestDAO dao;

    public List<Category> findAll(){
        return dao.findAll();
    }
    public Optional<Category> findById(){return dao.findById(1);}
}
