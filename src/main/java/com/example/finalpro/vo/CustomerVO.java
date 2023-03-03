package com.example.finalpro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {
    private String custid;
    private int cateid;
    private String pwd;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String addr_postcode;
    private String addr_address;
    private String addr_detail;
    private String addr_extra;
    private String gender;
    private String role;
}
