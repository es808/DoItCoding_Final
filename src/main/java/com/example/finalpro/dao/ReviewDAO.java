package com.example.finalpro.dao;

import com.example.finalpro.entity.Ranking;
import com.example.finalpro.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Integer> {


}