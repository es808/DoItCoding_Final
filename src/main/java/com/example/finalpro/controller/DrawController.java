package com.example.finalpro.controller;

import com.example.finalpro.dao.DrawDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.service.DrawService;
import com.example.finalpro.vo.TicketVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Setter
public class DrawController {

    @Autowired
    private DrawService drawService;

    @Autowired
    private DrawDAO drawDAO;

    @GetMapping("/draw")
    public ModelAndView draw(){
        ModelAndView mav = new ModelAndView("/ticket/draw");
        return mav;
    }

    // 잔여좌석이 0이거나 cateid=1일 때 드로우 버튼 활성화
    @RequestMapping("/DrawButtonOpen")
    @ResponseBody
    public TicketVO openDrawButton(int ticketid) {
        System.out.println("ticket번호:"+ticketid);
        return DBManager.findByTicketid(ticketid);
    }
}
