package com.example.finalpro.vo;

import lombok.Data;

@Data
public class ReviewVO {
    private int reviewId;
    private String custId;
    private int ticketId;
    private int score;
    private String review_content;
}
