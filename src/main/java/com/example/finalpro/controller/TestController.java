package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.service.CustomerService;
import com.example.finalpro.service.CategoryService;
import com.example.finalpro.service.TicketService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Setter
public class TestController {

    @Autowired
    private CustomerDAO dao;

    @Autowired
    private CategoryService ts;

    @Autowired
    private CustomerService cs;

    @Autowired
    private TicketService ticketService;

    //public void setDao(CustomerDAO dao){ this.dao = dao; }

    @RequestMapping("/list")
    public void list(Model model){
        model.addAttribute("list", dao.findAll());
    }

    @RequestMapping("/list_jpa")
    public void list_jpa(Model model){
        model.addAttribute("list", ts.findAll());
    }

    @RequestMapping("/list_jpa_id")
    public void list_jpa_id(Model model){
        model.addAttribute("list", ts.findById());
    }

    @RequestMapping("/list_customer")
    public void list_customer(Model model){
        model.addAttribute("list", cs.findAll());
    }

    @RequestMapping("/list_ticket")
    public void list_ticket(Model model){
        model.addAttribute("list", ticketService.findAll());
    }

}
