package com.example.finalpro.service;

import com.example.finalpro.dao.PlaceDAO;
import com.example.finalpro.entity.Place;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class PlaceService {

    @Autowired
    private PlaceDAO dao;

    public List<Place> findAll(){return dao.findAll();}
}
