package com.example.finalpro.dao;

import com.example.finalpro.entity.Customer;
import com.example.finalpro.entity.MyPageReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MyPageReviewDAO extends JpaRepository<MyPageReview, Integer> {
    public List<MyPageReview> findMyPageReviewByCustomer(Customer customer);
}