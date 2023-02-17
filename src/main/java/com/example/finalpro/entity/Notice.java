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
    private int notice_no;
    private String notice_title;
    private String notice_content;
    private String notice_hit;
    private Date notice_date;
    private String notice_category;
    private String notice_fname;
}
