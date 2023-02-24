package com.example.finalpro.service;

import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class TicketService {
    @Autowired
    private TicketDAO dao;

    public List<Ticket> findAll(){return dao.findAll();}

    public Optional<Ticket> findByTicketid(int ticketid){return dao.findById(ticketid);}
}
