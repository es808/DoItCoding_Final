package com.example.finalpro.vo;

import lombok.Data;

@Data
public class TicketVO {
    private int ticketid;
    private int cateid;
    private String placeid;
    private String ticket_name;
    private int price;
    private String ticket_date;
    private int min_age;
    private int runtime;
    private String cast;
    private String content;
    private String img_fname;
    private String vid_url;
    private String loc;
    private String lat;
    private String lng;
}
