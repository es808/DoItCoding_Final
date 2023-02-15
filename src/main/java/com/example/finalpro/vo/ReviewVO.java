package com.example.finalpro.vo;

import lombok.Data;

@Data
public class ReviewVO {
    private int reviewid;
    private String custid;
    private int ticketid;
    private int score;
    private String review_content;
}
