package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "notice")
public class Notice {
    @Id
    private int no;
    private String title;
    private String content;
    private String hit;
    private Date notice_date;
    private String category;
    private String f_name;
}
