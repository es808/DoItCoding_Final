package com.example.finalpro.dao;

import com.example.finalpro.entity.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {


}
