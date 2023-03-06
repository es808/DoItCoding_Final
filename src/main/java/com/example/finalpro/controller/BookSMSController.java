package com.example.finalpro.controller;

import com.example.finalpro.db.DBManager;
import com.example.finalpro.vo.BookVO;
import com.example.finalpro.vo.TicketVO;
import kr.co.youiwe.webservice.BitSms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
public class BookSMSController {
    @GetMapping("/sendBookingConfirmation")
    public String sendBookingConfirmation(String custid, int ticketid, int seatid, String phone){
        BookVO b=new BookVO(0, custid, ticketid, seatid);
        int bookid= DBManager.findBookidByOthers(b);
        TicketVO t=DBManager.findByTicketid(ticketid);
        String ticket_date=t.getTicket_date();
        String ticket_name=t.getTicket_name();
        String loc=t.getLoc();
        ticket_date=ticket_date.substring(0,16);
        String msg="[T-CATCH]\""+ticket_name+"\" 예약 완료. "+"예약번호: "+bookid+" ("
                +ticket_date+" "+loc+")";
        BitSms sms=new BitSms();
        sms.sendMsg("01025598279", phone, msg);
        return msg;
    }
}