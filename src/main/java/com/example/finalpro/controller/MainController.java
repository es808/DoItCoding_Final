package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.RankingDAO;
import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.dao.TicketDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Setter
public class MainController {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private RankingDAO rankingDAO;




}
