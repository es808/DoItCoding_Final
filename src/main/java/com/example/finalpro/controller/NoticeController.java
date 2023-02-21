package com.example.finalpro.controller;

import com.example.finalpro.db.DBManager;
import com.example.finalpro.service.NoticeService;
import com.example.finalpro.vo.NoticeVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Setter
public class NoticeController {
    @Autowired
    private NoticeService ns;

    @GetMapping("/notice/list")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("list",ns.findAll());
        return mav;
    }

    @GetMapping("/notice/detail/{notice_no}")
    public ModelAndView detail(@PathVariable int notice_no){
        ModelAndView mav=new ModelAndView("/notice/detail");
        mav.addObject("n",ns.findById(notice_no).get());
        return mav;
    }

    @GetMapping("/admin/notice/insert")
    public void insertForm(){}

    @PostMapping("/admin/notice/insert")
    public ModelAndView insertSubmit(NoticeVO n){
        System.out.println("controller 작동");
        ModelAndView mav=new ModelAndView("/notice/list");
        n.setNotice_fname("1");
        int re=DBManager.insertNotice(n);
        System.out.println("controller에서 re:"+re);
        if(re!=1) {
            mav.setViewName("/error");
        }
        return mav;
    }
}
