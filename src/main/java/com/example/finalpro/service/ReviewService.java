package com.example.finalpro.service;

import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.entity.Review;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class ReviewService {

    @Autowired
    private ReviewDAO dao;

    public List<Review> findAll(){return dao.findAll();}
}
