package com.example.finalpro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private int reviewid;
    private String custid;
    private int ticketid;
    private String ticket_name;
    private String ticket_date;
    private String img_fname;
    private int score;
    private String review_content;
}
