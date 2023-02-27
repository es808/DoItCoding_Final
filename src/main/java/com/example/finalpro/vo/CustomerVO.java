package com.example.finalpro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {
    private String custid;
    private String pwd;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String gender;
    private String addr;
    private String role;
    private int cateid;
}
