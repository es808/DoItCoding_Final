package com.example.finalpro.service;

import com.example.finalpro.dao.SeatDAO;
import com.example.finalpro.entity.Seat;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class SeatService {

    @Autowired
    private SeatDAO dao;

    public List<Seat> findAll(){return dao.findAll();}
}
