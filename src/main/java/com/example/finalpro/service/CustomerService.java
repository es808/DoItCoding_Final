package com.example.finalpro.service;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.entity.Customer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class CustomerService {

    @Autowired
    private CustomerDAO dao;

    public List<Customer> findAll(){return dao.findAll();}

    // 특정 회원의 정보를 출력하는 메소드
    // 1. main.html에서 회원의 선호하는 장르 cateid를 가져오기 위함
    public Customer findByCustid(String custid){
        if(dao.findById(custid).isPresent()){
            return dao.findById(custid).get();
        }
        return null;
    }
}
