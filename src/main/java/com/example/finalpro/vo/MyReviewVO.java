package com.example.finalpro.vo;

import lombok.Data;

@Data
public class MyReviewVO {
    private int reviewid;
    private String custid;
    private int ticketid;
    private int score;
    private String review_content;
    private int cateid;
    private String placeid;
    private String ticket_name;
    private int price;
    private String ticket_date;
    private String content;
    private String img_fname;
    private String img_fname_main;
    private String vid_url;
    private int min_age;
    private int runtime;
    private String cast;
    private String loc;
    private int lat;
    private int lng;
}
