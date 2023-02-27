//package com.example.finalpro.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.mail.internet.MimeMessage;
//
//@Controller
//public class EmailController {
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @GetMapping("/sendMailHtml")
//    public String sendMailHtml() {
//
//        //HTML 형태의 이메일을 발송하려면 MimeMessagePreparator 객체가 필요하다. 익명으로 생성
//        mailSender.send(new MimeMessagePreparator() {
//
//            @Override
//            public void prepare(jakarta.mail.internet.MimeMessage mimeMessage) throws Exception {
//
//            }
//
//            @Override
//            public void prepare(MimeMessage mimeMessage) throws Exception {
//                String str="<h2>회원가입 성공</h2>";
//                str+="<img src='cid:ball'>";
//                MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true, "UTF-8");
//                helper.setFrom("kgukgu33@gmail.com");
//                helper.setTo("kgukgu33@gmail.com");
//                helper.setSubject("html형태의 이메일 이미지 첨부파일");
//                helper.setText(str,true);
//
//                helper.addInline("ball", new ClassPathResource("img/ball1.jpg"));
//                helper.addAttachment("hello.txt", new ClassPathResource("doc/hello.txt"));
//            }
//        });
//
//        return "OK";
//    }
//}
//
//
////@RequestMapping("qna_notification_email/{custid}") @PathVariable String custid