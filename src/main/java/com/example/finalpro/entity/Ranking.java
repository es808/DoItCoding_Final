package com.example.finalpro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
@SecondaryTable(name = "review")
public class Ranking {
    @Id
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
    private String img_fname_main;
    private String vid_url;
    private String loc;
    private String lat;
    private String lng;
    private int reviewid;
    private String custid;
    private int score;
    private String review_content;
}
