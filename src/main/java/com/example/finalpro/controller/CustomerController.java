package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.dao.DrawDAO;
import com.example.finalpro.dao.SeatDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.entity.Customer;
import com.example.finalpro.entity.Draw;
import com.example.finalpro.service.CategoryService;
import com.example.finalpro.service.CustomerService;
import com.example.finalpro.service.TicketService;
import com.example.finalpro.util.SendMessage;
import com.example.finalpro.vo.CustomerVO;
import com.example.finalpro.vo.MyBookVO;
import com.example.finalpro.vo.MyDrawVO;
import com.example.finalpro.vo.TicketVO;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Setter
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/FindCustomer")
    @ResponseBody
    public CustomerVO findCustomer(String custid){
        return DBManager.findByCustid(custid);
    }

    static String code;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerDAO dao;

    @Autowired
    private CategoryService ts;

    @Autowired
    private CustomerService cs;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private DrawDAO drawDAO;

    @Autowired
    private SeatDAO seatDAO;


    //public void setDao(CustomerDAO dao){ this.dao = dao; }

    @RequestMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", dao.findAll());
    }

    @RequestMapping("/list_jpa")
    public void list_jpa(Model model){
        model.addAttribute("list", ts.findAll());
    }

    @RequestMapping("/list_jpa_id")
    public void list_jpa_id(Model model) {
        model.addAttribute("list", ts.findById());
    }

    @RequestMapping("/list_customer")
    public void list_customer(Model model) {
        model.addAttribute("list", cs.findAll());
    }

    @RequestMapping("/list_ticket")
    public void list_ticket(Model model) {
        model.addAttribute("list", ticketService.findAll());
    }

    @GetMapping("/login")
    public void login() {
    }


    @GetMapping("/signUp")
    public void signUp() {
    }

    @GetMapping("/")
    public String home() {
        return "/main";
    }

    @GetMapping("/main")
    public ModelAndView main(HttpSession session, Model m){
        ModelAndView mav = new ModelAndView("/main");
        //인증된(로그인한) 회원의 정보를 가져오기 위하여
        //시큐리티의 인증객체가 필요.
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        //이 인증객체를 통해서 인증된(로그인된) User객체를 받아 온다.

        System.out.println(authentication.getPrincipal());

        if(!authentication.getPrincipal().equals("anonymousUser")){
            User user = (User) authentication.getPrincipal();



            //이 인증된 User를 통해서 로그인된 회원의 아이디를 가져온다.

            String id = user.getUsername();
            //아이디 정보를 세션에 상태유지 한다.
            //만약, id뿐 아니라 로그인한 회원의 다른정보도 필요하다면 dao를 통해 회원 정보를 가져와서 상태유지

            session.setAttribute("id", id);
            System.out.println("session id = " + session.getAttribute("id"));
            m.addAttribute("id", id);
        }else{
            session.removeAttribute("id");
            m.addAttribute("id","none");
        }
        return mav;
    }

    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model m) {
        System.out.println((String) session.getAttribute("id"));
        String id = (String) session.getAttribute("id");
        Optional<Customer> c = customerDAO.findById(id);
        System.out.println(c.get());
        m.addAttribute("id",c.get());
        return "myPage/myPage";
    }

    @PostMapping("/myPage")
    public String updateCustomer(CustomerVO c, HttpSession session, Model m){
        System.out.println("업데이트 컨트롤러 가동:"+c);
        c.setPwd(passwordEncoder.encode(c.getPwd()));
        System.out.println("암호화 : "+c);
        c.setRole("customer");

        try{
            DBManager.updateCustomer(c);
            System.out.println("sessionId = "+session.getAttribute("id"));
            myPage(session,m);
        }catch (Exception e){

        }
        return "myPage/myPage";
    }

//    @GetMapping("/myPageDraw")
//    public String myPageDraw(Model m) {
//        DrawController drawController = new DrawController();
//        String result[] =  drawController.drawResult();
//        m.addAttribute("list", result);
//        System.out.println(DBManager.drawLeftSeat(1));
//
//        return "myPage/myPageDraw";
//    }

    @GetMapping("/myPageDraw")
    public String myPageDraw(HttpSession session, Model m){
        String custid = (String)session.getAttribute("id");
        List<MyDrawVO> myDraw = new ArrayList<>();
        TicketVO myTicket = null;

        List<Draw> list = drawDAO.findByCustid(custid);

        for(Draw d : list){
            MyDrawVO md = new MyDrawVO();
            myTicket = DBManager.findByTicketid(d.getTicketid());
            md.setCustid(d.getCustid());
            md.setDrawid(d.getDrawid());
            md.setSeatid(d.getSeatid());
            md.setTicketid(d.getTicketid());
            md.setImg_fname(myTicket.getImg_fname());
            md.setLoc(myTicket.getLoc());
            md.setTicket_date(myTicket.getTicket_date());
            md.setTicket_name(myTicket.getTicket_name());
            md.setSeatname(seatDAO.findById(d.getSeatid()).get().getSeatname());
            System.out.println(md);
            myDraw.add(md);
        }

        m.addAttribute("list",myDraw);

        return "myPage/myPageDraw";
    }

    @GetMapping("/test")
    public String test(){
        return "list";
    }

    @GetMapping("/myPageBook")
    public String myPageBook() { return "myPage/myPageBook";}

    @GetMapping("/myPageDraw")
    public String myPageDraw(Model m) {
        DrawController drawController = new DrawController();
        String result[] =  drawController.drawResult();
        m.addAttribute("list", result);
        System.out.println(DBManager.drawLeftSeat(1));

        return "myPage/myPageDraw";}

    @GetMapping("/myPageReview")
    public String myPageReview() { return "myPage/myPageReview";}

    @PostMapping("/signUp")
    public ModelAndView signUpSubmit(Customer c) {
        System.out.println("customer:"+c);
//		String encPwd = passwordEncoder.encode(m.getPwd());
//		m.setPwd(encPwd);
        ModelAndView mav = new ModelAndView("redirect:/login");
        System.out.println(c.getPwd());
        c.setPwd(passwordEncoder.encode(c.getPwd()));
        System.out.println("customer = " + c);
        c.setRole("customer");
        try {
            System.out.println(c);
            customerDAO.save(c);
            mav.setViewName("/login");
        } catch (Exception e) {
            mav.addObject("msg", "회원가입에 실패하였습니다.");
            mav.setViewName("/error");
        }

		/*
		memberDAO.save(m);
		Optional<Member> obj = memberDAO.findById(m.getId());
		if(obj.isEmpty()) {
			mav.addObject("msg", "회원가입에 실패하였습니다.");
			mav.setViewName("error");
		}*/
        return mav;
    }

    //아이디 중복 확인 메소
    @GetMapping("/ConfirmCustomerId")
    @ResponseBody
    public int confirmCustomerId(String custid){
        int answer = 0;
        if(customerDAO.findById(custid).isPresent()){
            answer=1;
        }
        return answer;
    }

    //비밀번호 중복 확인 메소드
    @GetMapping("/ConfirmCustomerPhone")
    @ResponseBody
    public int confirmCustomerPhone(String phone, HttpSession session){
        int answer = 0;
        String myPhone = "none";
        if(session.getAttribute("id")!=null){
            String id = (String)session.getAttribute("id");
            myPhone = customerDAO.findById(id).get().getPhone();
        }

        System.out.println("myPhone:"+myPhone);

        System.out.println(!myPhone.equals(phone));
        System.out.println(phone);
        if(customerDAO.findByPhone(phone) != null ){
            answer=1;
        }
        if(myPhone.equals(phone)){
            answer = 0;
        }
        return answer;
    }

    @GetMapping("/CustomerPhoneAuthentication")
    @ResponseBody
    public int customerPhoneAuthentication(String phoneCode){
        System.out.println(this.code);
        System.out.println("code:"+phoneCode);
        int answer = 0;
        if(!this.code.equals(phoneCode)){
            answer = 1;
        }
        System.out.println(answer);
        return answer;
    }

    @GetMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(String phone){
        System.out.println("phone:"+phone);
        code = SendMessage.sendCodePhone(phone);
        System.out.println("code:"+code);

//        MessageController ms = new MessageController();
//        code = ms.sendCodePhone(phone);
        return code;
    }

}