package com.example.finalpro.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerVO {
    private String custid;
    private String pwd;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String gender;
    private int cateid;
    private String favor;
}
