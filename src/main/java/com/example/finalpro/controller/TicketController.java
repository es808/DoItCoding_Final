package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.ReviewDAO;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.vo.NotificationByCustidVO;
import com.example.finalpro.vo.NotificationVO;
import com.example.finalpro.service.TicketService;
import com.example.finalpro.vo.RankingVO;
import com.example.finalpro.vo.TicketVO;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Setter
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private TicketDAO ticketDAO;

    @GetMapping("/search")
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView("/ticket/search");
        return mav;
    }

    @GetMapping("/category")
    public ModelAndView category(){
        ModelAndView mav = new ModelAndView("/ticket/category");
        return mav;
    }

    // 티켓 상세페이지
    @GetMapping("/detail")
    public ModelAndView detail(){
        ModelAndView mav = new ModelAndView("/detail");
        return mav;
    }

    // 랭킹 출력 ajax 통신 받기
    @RequestMapping(value = "/RankingTicket", method = RequestMethod.GET)
    @ResponseBody
    public List<RankingVO> rankingTicket(int cateid){
        System.out.println("cateid "+cateid);
        return DBManager.findAllRankingOrderByScore(cateid);
    }


    // 시간, 장르 별로 Ajax 출력하기
    @RequestMapping("/SelectTicketMain")
    @ResponseBody
    public List<TicketVO> selectTicket(int cateid, int time){
        System.out.println("cateid "+cateid);
        System.out.println("time "+time);

        return DBManager.findAllTicketByCategory(time,cateid);
    }

    // 검색 결과 ticket들 Ajax 출력하기
    @RequestMapping("/SearchTicket")
    @ResponseBody
    public List<TicketVO> selectSearchTicket(String keyword){
        System.out.println("keyword :"+keyword);

        return DBManager.findSearchTicket(keyword);
    }

//    @RequestMapping("/RankingTicket")
//    @ResponseBody
//    public List<Ranking> main(@RequestParam("cateid")int cateid){
//        return rankingDAO.findAllRanking(cateid);
//    }

    // 티켓의 디테일 정보 뜨게 Ajax 활용해서 기능구현
    @RequestMapping("/DetailTicket")
    @ResponseBody
    public TicketVO selectDetailTicket(int ticketid) {
        System.out.println("ticket번호:"+ticketid);
        return DBManager.findByTicketid(ticketid);
    }

    // 티켓의 디테일페이지에서 예매버튼 활성화 기능 Ajax 활용해서 구현
    @RequestMapping("/BookButtonOpen")
    @ResponseBody
    public TicketVO openBookButton(int ticketid) {
        System.out.println("ticket번호:"+ticketid);
        return DBManager.findByTicketid(ticketid);
    }


    // 남은 좌석수 ajax 구현
    @RequestMapping("/LeftSeat")
    @ResponseBody
    public int selectLeftSeat(int ticketid) {
        System.out.println("ticket번호:"+ticketid);
        return DBManager.findLeftSeatByTicketid(ticketid);
    }

    // 서버시간 가져오는 ajax
    @RequestMapping("/ServerTime")
    @ResponseBody
    public String getServerTime(){
        // 현재 시간
        LocalTime now = LocalTime.now();
        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // 포맷 적용하기
        String formatedNow = now.format(formatter);

        return formatedNow;
    }

}
