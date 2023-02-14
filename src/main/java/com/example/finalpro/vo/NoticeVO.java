package com.example.finalpro.vo;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeVO {
    private int no;
    private String title;
    private String content;
    private String hit;
    private Date notice_date;
    private String category;
    private String f_name;
}
