package com.example.finalpro.service;

import com.example.finalpro.dao.DrawDAO;
import com.example.finalpro.entity.Draw;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class DrawService {

    @Autowired
    private DrawDAO dao;

    public List<Draw> findAll(){return dao.findAll();}
}
