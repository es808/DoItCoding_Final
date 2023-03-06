package com.example.finalpro.vo;

import lombok.Data;


@Data
public class MyBookVO {
    private int bookid;
    private int ticketid;
    private int seatid;
    private String img_fname;
    private String ticket_name;
    private String ticket_date;
    private String loc;
    private String seatname;

}
