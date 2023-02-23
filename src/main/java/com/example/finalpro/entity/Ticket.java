package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    //JPA는 테이블 속성명과 엔티티의 변수명을 똑같이해야 인식함.
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
    private String vid_url;
    private String loc;
    private String lat;
    private String lng;
}