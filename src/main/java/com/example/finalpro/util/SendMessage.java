package com.example.finalpro.util;

import kr.co.youiwe.webservice.BitSms;

import java.util.Random;
public class SendMessage {
    public static String sendCodePhone(String phone) {
        System.out.println("문자 전송!");
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
        sms.sendMsg("01025598279", phone, msg + code);
        System.out.println("문자 전송 완료!");
        return code;
    }
}
