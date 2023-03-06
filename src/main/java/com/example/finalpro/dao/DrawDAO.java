package com.example.finalpro.dao;

import com.example.finalpro.entity.Customer;
import com.example.finalpro.entity.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrawDAO extends JpaRepository<Draw, Integer> {

    List<Draw> findByTicketid(int ticketid);

    List<Draw> findByCustid(String custid);

//    List<Draw> findByCustomer(Customer customer);
}
