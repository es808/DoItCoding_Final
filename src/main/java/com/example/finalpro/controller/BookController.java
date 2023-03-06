package com.example.finalpro.controller;

import com.example.finalpro.dao.BookDAO;
import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.service.BookService;
import com.example.finalpro.vo.CountGenderVO;
import com.example.finalpro.vo.CountGenerationVO;
import com.example.finalpro.vo.MyBookVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public List<CountGenerationVO> countGeneration(int ticketid){
        return DBManager.countGeneration(ticketid);
    }

    // 예매하기
    @RequestMapping("/BookTicket")
    @ResponseBody
    public int bookTicket(String custid, int ticketid, int seatid){
        return DBManager.bookTicket(custid,ticketid,seatid);
    }


    @RequestMapping("/regist2")
    public ModelAndView regist2(){
        ModelAndView mav = new ModelAndView("/ticket/regist2");
        return mav;
    }

    // 결제하기
    @RequestMapping("/payok")
    @ResponseBody
    public String payok(String imp_uid,String merchant_uid, int paid_amount, String apply_num){
        System.out.println("imp_uid:"+imp_uid);
        System.out.println("merchant_uid:"+merchant_uid);
        System.out.println("paid_amount:"+paid_amount);
        System.out.println("apply_num:"+apply_num);
        return "OK";
    }

    // 내 예매내역 출력하기
    @RequestMapping("/BookByCustid")
    @ResponseBody
    public List<MyBookVO> bookByCustid(String custid){
        return DBManager.bookByCustid(custid);
    }

    // 내 예매내역 삭제
    @RequestMapping("/DeleteBook")
    @ResponseBody
    public int deleteBook(int bookid){
        return DBManager.deleteBook(bookid);
    }
}
