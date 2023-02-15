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
}
