package com.example.finalpro;

import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class test {

    @Autowired
    private static TicketDAO ticketDAO;

    public static void main(String[] args) {
        List<Ticket> tickets = ticketDAO.findAll();
        for(Ticket t : tickets){
            t.getTicket_date();
        }

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDate());
    }

}
