package com.example.finalpro.service;

import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class TicketService {
    @Autowired
    private TicketDAO dao;

    public List<Ticket> findAll(){return dao.findAll();}

    //public Ticket findByTicketid(int ticketid){return dao.findByTicketid(ticketid);}
}
