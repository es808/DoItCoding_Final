package com.example.finalpro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDrawVO {
    private int drawid;
    private String custid;
    private int ticketid;
    private int seatid;
    private String img_fname;
    private String ticket_name;
    private String ticket_date;
    private String loc;
    private String seatname;
}
