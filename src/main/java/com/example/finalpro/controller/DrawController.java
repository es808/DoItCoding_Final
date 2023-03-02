package com.example.finalpro.controller;

import com.example.finalpro.dao.DrawDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.entity.Draw;
import com.example.finalpro.service.DrawService;
import com.example.finalpro.vo.DrawVO;
import com.example.finalpro.vo.TicketVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

    @GetMapping("/drawTest")
    public String drawTest(Model m){
        List<Draw> draw = null;
        draw = DBManager.drawTest(1);
        m.addAttribute("list",draw);
        return "drawTest/drawTest";
    }

    @GetMapping("/drawList")
    @ResponseBody
    public List<DrawVO> drawList(){
        List<DrawVO> draw = null;
        draw = DBManager.drawTest(1);
        return draw;
    }
    
    //drawTest2
    @GetMapping("/drawTest2")
    @ResponseBody
    public void drawTest2(){
        int count = DBManager.findLeftSeatByTicketid(1);
        List<DrawVO> draw = drawList();
        System.out.println("드로우 사이즈:"+draw.size());
        String arr[] = new String[count];

        LinkedList<DrawVO> list = new LinkedList<>();

        for(DrawVO d : draw){
            list.add(d);
        }

        System.out.println(list);





        for (int i = 0; i < count; i++){
            Random r = new Random();
            int number = r.nextInt(list.size());
            arr[i] = list.get(number).getCustid();
            list.remove(number);
            System.out.println(list.size());
        }

        for(int i = 0; i < count; i++){
            System.out.println(arr[i]);
        }
        System.out.println(count);
    }
}
