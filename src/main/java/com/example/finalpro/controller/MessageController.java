package com.example.finalpro.controller;

import kr.co.youiwe.webservice.BitSms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MessageController {
    @GetMapping("/sendMsg")
    public String sendMsg() {
        String from = "01025598279";
        String to = "01041418894";
        String msg = "밥 묵았나?";

        BitSms sms = new BitSms();
        sms.sendMsg(from, to, msg);
        return "OK";
    }


    @GetMapping("/sendCodePhone")
    public String sendCodePhone(String phone) {
        String msg = "티캣치 인증번호 발신\n";
        String code = "";
        Random r = new Random();
        code += r.nextInt(10);
        code += r.nextInt(10);
        code += r.nextInt(10);
        code += r.nextInt(10);
        code += r.nextInt(10);
        code += r.nextInt(10);

        BitSms sms = new BitSms();
        sms.sendMsg("01025598279",phone, msg+code);
        return code;
    }
}
