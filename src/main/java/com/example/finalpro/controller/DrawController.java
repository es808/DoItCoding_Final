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

    //드로우 신청한 회원정보 가져오기
    @GetMapping("/drawList")
    @ResponseBody
    public List<DrawVO> drawList(int ticketid){
        List<DrawVO> draw = null;
        draw = DBManager.drawTest(ticketid);
        return draw;
    }

    //드로우 가동
    @GetMapping("/drawTest2")
    @ResponseBody
    public String[] drawTest2(){
        int count = DBManager.findLeftSeatByTicketid(1);
        List<DrawVO> draw = drawList(1);
        System.out.println("드로우 사이즈:"+draw.size());
        String arr[] = new String[count];           //드로우에 당첨된 회원아이디 저장

        LinkedList<DrawVO> list = new LinkedList<>();

        for(DrawVO d : draw){
            list.add(d);
        }
        System.out.println(list);

        for (int i = 0; i < count; i++){
            Random r = new Random();
            int number = r.nextInt(list.size());        //랜덤함수를 드로우를 신청한 회원 수 만큼의 크기로 설정
            arr[i] = list.get(number).getCustid();      //랜덤함수에 배정된 회원아이디를 배열에 저장
            list.remove(number);                        //당첨된 회원은 linkedList에서 제거하고 다시 반복문 가동
            System.out.println(list.size());
        }
        return arr;
    }

    @GetMapping("/drawTest")
    public String drawTest(Model m){
        String arr[] = drawTest2();
        m.addAttribute("list", arr);
        System.out.println(arr[1]);
        return "drawTest/drawTest";
    }


}
