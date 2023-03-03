package com.example.finalpro.dao;

import com.example.finalpro.entity.Draw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawDAO extends JpaRepository<Draw, Integer> {

    List<Draw> findByTicketid(int ticketid);
    
}
