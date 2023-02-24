package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import com.example.finalpro.service.TicketService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Setter
public class AdminController {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private TicketService ticketService;

    // admin에서 listTicket 페이지를 열기
    @GetMapping("/admin/listTicket")
    public ModelAndView adminListTicket(Model model){
        ModelAndView mav = new ModelAndView("/admin/ticket/listTicket");
        model.addAttribute("list", ticketService.findAll());

        return mav;
    }

    // admin 에서 insertTicket 페이지를 열고 form을 보내기
    @GetMapping("/admin/insertTicket")
    public ModelAndView adminInsertTicket(){
        ModelAndView mav = new ModelAndView("/admin/ticket/insertTicket");
        return mav;
    }

    @PostMapping("/admin/insertTicket")
    public ModelAndView adminInsertTicketSubmit(Ticket ticket, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("redirect:/admin/ticket/listTicket");

        ticketService.insertTicket(ticket, request);

        return mav;
    }

    // admin에서 updateTicket 페이지 열기
    @GetMapping("/admin/updateTicket/{ticketid}")
    public ModelAndView adminUpdateTicket(@PathVariable int ticketid, Model model){
        ModelAndView mav = new ModelAndView("/admin/ticket/updateTicket");
        model.addAttribute("ticket", ticketDAO.findById(ticketid));
        return mav;
    }

    // ticket 삭제하기
    @RequestMapping("/admin/deleteTicket/{ticketid}")
    @ResponseBody
    public ModelAndView adminDeleteTicket(@PathVariable int ticketid){
        ModelAndView mav = new ModelAndView("redirect:/admin/ticket/listTicket");
        ticketDAO.deleteById(ticketid);
        
        return mav;
    }

}
