package com.example.finalpro.controller;

import com.example.finalpro.db.DBManager;
import com.example.finalpro.entity.Customer;
import com.example.finalpro.entity.MyPageReview;
import com.example.finalpro.service.CustomerService;
import com.example.finalpro.service.ReviewService;
import com.example.finalpro.service.TicketService;
import com.example.finalpro.vo.ReviewVO;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@Setter
public class MyPageReviewController {

    @Autowired
    private ReviewService rs;

    @Autowired
    private CustomerService cs;

    @Autowired
    private TicketService ts;

    @GetMapping("/myPageReview")
    public ModelAndView MyPageReview(HttpSession session){
        ModelAndView mav=new ModelAndView("/myPage/myPageReview");
        String loginId=(String) session.getAttribute("id");
        Customer loginCustomer=cs.findByCustid(loginId);
        mav.addObject("list",rs.findByCustid(loginCustomer));
        return mav;
    }

    //리뷰 등록 폼
    @GetMapping("/myPage/insertReview/{ticketid}")
    public ModelAndView insertForm(@PathVariable String ticketid){
        ModelAndView mav=new ModelAndView("insert");
        mav.addObject("ticketid",ticketid);
        return mav;
    }

    @PostMapping("/myPage/insertReview")
    public ModelAndView insertSubmit(HttpSession session, ReviewVO r){
        ModelAndView mav=new ModelAndView();
        String loginId=(String) session.getAttribute("id");
        r.setCustid(loginId);

        // 중복 체크 (아이디와 티켓아이디 겹치는 것 있는지 확인) (갯수 반환함)
        int re_check=DBManager.checkReviewByTicketid(r);
        if(re_check==0){
            int re=DBManager.insertReview(r);
            mav.setViewName("redirect:/myPageReview");
        }else{
            mav.addObject("msg", "이미 해당 작품에 대한 리뷰를 등록했습니다.");
            mav.setViewName("/error");
        }
        return mav;
    }

    @GetMapping("/myPage/updateReview/{reviewid}")
    public ModelAndView updateForm(@PathVariable int reviewid){
        ModelAndView mav=new ModelAndView();
        Optional<MyPageReview> optionalMyPageReview=rs.findById(reviewid);
        MyPageReview r=new MyPageReview();
        if(optionalMyPageReview.isPresent()){
            r=optionalMyPageReview.get();
        }else{
            mav.addObject("msg","존재하지 않는 리뷰입니다.");
            mav.setViewName("/error");
        }
        mav.addObject("r",r);
        mav.setViewName("/myPage/updateReview");
        return mav;
    }

    @PostMapping("/myPage/updateReview")
    public ModelAndView updateSubmit(MyPageReview r, String custid, int ticketid){
        ModelAndView mav=new ModelAndView("redirect:/myPageReview");
        r.setCustomer(cs.findByCustid(custid));
        r.setTicket(ts.findByTicketid(ticketid).get());
        rs.save(r);
        return mav;
    }

    @GetMapping("/myPage/deleteReview/{reviewid}")
    public ModelAndView delete(@PathVariable int reviewid){
        ModelAndView mav=new ModelAndView("redirect:/myPageReview");
        Optional<MyPageReview> optionalMyPageReview=rs.findById(reviewid);
        MyPageReview r=new MyPageReview();
        if(optionalMyPageReview.isPresent()){
            r=optionalMyPageReview.get();
        }else{
            mav.setViewName("/error");
        }
        rs.delete(r);
        return mav;
    }

    // 티켓의 리뷰가 있나 확인
//    @GetMapping("/CheckReview")
//    @ResponseBody
//    public int findCheckReview(String custid, int ticketid){
//        MyReviewVO r=new MyReviewVO();
//        r.setCustid(custid);
//        r.setTicketid(ticketid);
//        return DBManager.checkReviewByTicketid(r);
//    }

//    // 리뷰 등록 submit AJAX
//    @PostMapping("/InsertReview")
//    @ResponseBody
//    public int insertSubmit(String custid, int ticketid, int score, String review_content){
//        ReviewVO r=new ReviewVO(0, custid, ticketid, score, review_content);
//        return DBManager.insertReview(r);
//    }
}
