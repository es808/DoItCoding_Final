package com.example.finalpro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationByCustidVO {
    private int notif_no;
    private String qna_title;
    private Date notif_date;
}
