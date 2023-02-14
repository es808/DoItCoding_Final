package com.example.finalpro.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QnaVO {
    private int no;
    private String custId;
    private String title;
    private String content;
    private int hit;
    private Date notice_date;
    private String category;
    private String f_name;
    private String answer;
    private char open;
}
