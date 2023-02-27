//package com.example.finalpro.controller;
//
//import com.example.finalpro.dao.CustomerDAO;
//import com.example.finalpro.db.DBManager;
//import com.example.finalpro.entity.Customer;
//import com.example.finalpro.service.CustomerService;
//import com.example.finalpro.service.CategoryService;
//import com.example.finalpro.service.TicketService;
//import com.example.finalpro.vo.CustomerVO;
//import jakarta.servlet.http.HttpSession;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Date;
//import java.util.Optional;
//
//@Controller
//@Setter
//public class TestController {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private CustomerDAO dao;
//
//    @Autowired
//    private CategoryService ts;
//
//    @Autowired
//    private CustomerService cs;
//
//    @Autowired
//    private CustomerDAO customerDAO;
//
//    @Autowired
//    private TicketService ticketService;
//
//
//    //public void setDao(CustomerDAO dao){ this.dao = dao; }
//
//    @RequestMapping("/list")
//    public void list(Model model) {
//        model.addAttribute("list", dao.findAll());
//    }
//
//    @RequestMapping("/listJpa")
//    public void list_jpa(Model model) {
//        model.addAttribute("list", DBManager.findAll());
//        System.out.println("D매니저가능:"+DBManager.findAll());
//    }
//
//    @RequestMapping("/list_jpa_id")
//    public void list_jpa_id(Model model) {
//        model.addAttribute("list", ts.findById());
//    }
//
//    @RequestMapping("/list_customer")
//    public void list_customer(Model model) {
//        model.addAttribute("list", cs.findAll());
//    }
//
//    @RequestMapping("/list_ticket")
//    public void list_ticket(Model model) {
//        model.addAttribute("list", ticketService.findAll());
//    }
//
//    @GetMapping("/login")
//    public void login() {
//    }
//
//    @GetMapping("/join")
//    public void join() {
//    }
//
//    @GetMapping("/signUp")
//    public void signUp() {
//    }
//
//    @GetMapping("/")
//    public String home() {
//        return "list";
//    }
//
//    @GetMapping("/myPage")
//    public String myPage(HttpSession session, Model m) {
//        System.out.println((String) session.getAttribute("id"));
//        String id = (String) session.getAttribute("id");
//        Optional<Customer> c = customerDAO.findById(id);
//        System.out.println(c.get());
//        m.addAttribute("id",c.get());
//        return "myPage/myPage";
//    }
//
//    @PostMapping("/myPage")
//    public ModelAndView updateCustomer(CustomerVO c){
//        System.out.println("업데이트 컨트롤러 가동:"+c);
//        ModelAndView mav = new ModelAndView("redirect:myPage/myPage");
//        c.setPwd(passwordEncoder.encode(c.getPwd()));
//        System.out.println("암호화 : "+c);
//        c.setRole("customer");
//        try{
//            DBManager.updateCustomer(c);
//            mav.addObject("list", dao.findById(c.getCustid()).get());
//            mav.setViewName("myPage/myPage");
//        }catch (Exception e){
//            mav.setViewName("error");
//        }
//        return mav;
//    }
//
//    @GetMapping("/test")
//    public String test(){
//        return "list";
//    }
//
//
//    @GetMapping("/myPageBook")
//    public String myPageBook() { return "myPage/myPageBook";}
//
//    @GetMapping("/myPageReview")
//    public String myPageReview() { return "myPage/myPageReview";}
//
//    @PostMapping("/signUp")
//    public ModelAndView signUpSubmit(Customer c) {
//        System.out.println("customer:"+c);
////		String encPwd = passwordEncoder.encode(m.getPwd());
////		m.setPwd(encPwd);
//        ModelAndView mav = new ModelAndView("redirect:/login");
//        System.out.println(c.getPwd());
//        c.setPwd(passwordEncoder.encode(c.getPwd()));
//        System.out.println("customer = " + c);
//        c.setRole("customer");
//        try {
//            System.out.println(c);
//            customerDAO.save(c);
//            mav.setViewName("/login");
//        } catch (Exception e) {
//            mav.addObject("msg", "회원가입에 실패하였습니다.");
//            mav.setViewName("error");
//        }
//
//		/*
//		memberDAO.save(m);
//		Optional<Member> obj = memberDAO.findById(m.getId());
//		if(obj.isEmpty()) {
//			mav.addObject("msg", "회원가입에 실패하였습니다.");
//			mav.setViewName("error");
//		}*/
//        return mav;
//    }
}