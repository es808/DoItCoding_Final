package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.entity.Ticket;
import com.example.finalpro.service.TicketService;
import com.example.finalpro.vo.TicketVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = {"/admin/insertTicket"})
    public ModelAndView adminInsertTicketSubmit(TicketVO ticket, String ticket_date2) throws ParseException {
        ModelAndView mav = new ModelAndView("redirect:/admin/listTicket");

        System.out.println("여기 도착!!!!!");
        System.out.println("등록하는 ticket "+ticket);
        
        // html에서 받은 날짜 + 시간을 합치고 Date 형태로 변환하여 db에 넣기
        String ticket_date = ticket.getTicket_date();
        ticket_date = ticket_date + ticket_date2;
       ticket.setTicket_date(ticket_date);
        System.out.println(ticket_date);

        ticketService.insertTicket(ticket);

        return mav;
    }

    // admin에서 updateTicket 기능하기
    @GetMapping("/admin/updateTicket/{ticketid}")
    public ModelAndView adminUpdateTicket(@PathVariable int ticketid){
        ModelAndView mav = new ModelAndView("/admin/ticket/updateTicket");

    if(ticketDAO.findById(ticketid).isPresent()){
        Ticket ticket = ticketDAO.findById(ticketid).get();
        mav.addObject("ticket", ticket);
        
        // view에서 ticket_date를 날짜와 시간값을 한번에 보낼 수 없으므로 두 개를 잘라서 따로따로 보내기 위한 작업
        // ticket_date1 2023-03-04
        // ticket_date2 13:15:00
        // 형태로 각각 보내서 수정할 때 일일히 값을 입력하지 않아도 날짜 데이터가 자동으로 나오게 상태유지한다
        String ticket_date = ticket.getTicket_date();
        String[] list_ticket_date = ticket_date.split("\\s");
        String ticket_date1 = list_ticket_date[0];
        String ticket_date2 = list_ticket_date[1];

        mav.addObject("ticket_date1", ticket_date1);
        mav.addObject("ticket_date2", ticket_date2);

    }
        return mav;
    }

    @PostMapping(value = {"/admin/updateTicket"})
    public ModelAndView adminUpdateTicketSubmit(TicketVO ticket, String ticket_date2){
        ModelAndView mav = new ModelAndView("redirect:/admin/listTicket");

        System.out.println("여기 도착!!!!!");
        System.out.println("등록하는 ticket "+ticket);

        // html에서 받은 날짜 + 시간을 합치고 Date 형태로 변환하여 db에 넣기
        String ticket_date = ticket.getTicket_date();
        ticket_date = ticket_date + ticket_date2;
        ticket.setTicket_date(ticket_date);
        System.out.println(ticket_date);

        ticketService.updateTicket(ticket);

        return mav;
    }

    // ticket 삭제하기
    @RequestMapping("/admin/deleteTicket/{ticketid}")
    @ResponseBody
    public ModelAndView adminDeleteTicket(@PathVariable int ticketid){
        ModelAndView mav = new ModelAndView("redirect:/admin/listTicket");
        ticketDAO.deleteById(ticketid);
        
        return mav;
    }
}
