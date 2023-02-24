package com.example.finalpro.controller;

import com.example.finalpro.dao.BookDAO;
import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.service.BookService;
import com.example.finalpro.vo.CountGenderVO;
import com.example.finalpro.vo.CountGenerationVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Setter
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private BookDAO bookDAO;

    //성별별로 예약자 수 구하기
    @RequestMapping("/CountGender")
    @ResponseBody
    public List<CountGenderVO> countGender(int ticketid){
        System.out.println("DBManager-countGender:"+DBManager.countGender(ticketid));
        return DBManager.countGender(ticketid);
    }

    //세대별로 예약자 수 구하기
    @RequestMapping("/CountGeneration")
    @ResponseBody
    public  List<CountGenerationVO> countGeneration(int ticketid){
        return DBManager.countGeneration(ticketid);
    }
}
