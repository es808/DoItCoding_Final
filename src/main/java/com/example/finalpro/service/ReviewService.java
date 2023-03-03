package com.example.finalpro.service;

import com.example.finalpro.dao.MyPageReviewDAO;
import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.entity.Customer;
import com.example.finalpro.entity.MyPageReview;
import com.example.finalpro.entity.Review;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class ReviewService {

    @Autowired
    private ReviewDAO dao;

    @Autowired
    private MyPageReviewDAO myPageReviewDAO;

    public List<Review> findAll(){return dao.findAll();}

    public List<MyPageReview> findByCustid(Customer customer){
        return myPageReviewDAO.findMyPageReviewByCustomer(customer);
    }

    public Optional<MyPageReview> findById(int reviewid){
        return myPageReviewDAO.findById(reviewid);
    }

    public void save(MyPageReview r){
        myPageReviewDAO.save(r);
    }

    public void delete(MyPageReview r) {
        myPageReviewDAO.delete(r);
    }
}
