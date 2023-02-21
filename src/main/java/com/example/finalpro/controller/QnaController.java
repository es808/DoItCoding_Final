package com.example.finalpro.controller;

import com.example.finalpro.service.QnaService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Setter
public class QnaController {
    @Autowired
    private QnaService qs;

    @GetMapping("/qna/list")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("list", qs.findAll());
        return mav;
    }

    @GetMapping("/qna/detail/{qna_no}")
    public ModelAndView detail(@PathVariable int qna_no){
        ModelAndView mav=new ModelAndView("/qna/detail");
        mav.addObject("q",qs.findById(qna_no).get());
        return mav;
    }

}
