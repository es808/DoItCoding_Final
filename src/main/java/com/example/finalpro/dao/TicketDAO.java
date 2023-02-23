package com.example.finalpro.dao;

import com.example.finalpro.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {

}
