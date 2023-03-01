package com.example.finalpro.controller;

import com.example.finalpro.dao.SeatDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.service.SeatService;
import com.example.finalpro.vo.SeatVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Setter
public class SeatController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatDAO seatDAO;

    @Autowired
    private TicketDAO ticketDAO;

    @GetMapping("/regist")
    public ModelAndView regist(){
        ModelAndView mav = new ModelAndView("/ticket/regist");
        return mav;
    }

    // Tikcetid의 전체 좌석 목록 출력
    @RequestMapping("/ListSeat")
    @ResponseBody
    public List<SeatVO> listSeatByTicketid(int ticketid){
        return DBManager.listSeatByTicketid(ticketid);
    }

    // 예매를 위해 ticketid와 seatname으로 좌석 아이디 찾기
    @RequestMapping("/FindSeatid")
    @ResponseBody
    public int findSeatId(int ticketid, String seatname){
        System.out.println("ticketid:"+ticketid);
        System.out.println("seatname:"+seatname);
        return DBManager.findSeatId(ticketid,seatname);
    }

    // 좌석예매
    @RequestMapping("/RegistBook")
    @ResponseBody
    public int registSeat(int seatid){
        System.out.println("SeatController에서 seatid:"+seatid);
        return DBManager.registSeat(seatid);
    }


}
