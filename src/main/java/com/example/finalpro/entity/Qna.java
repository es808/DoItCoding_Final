package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "qna")
public class Qna {
    @Id
    private int no;
    private String custid;
    private String title;
    private String content;
    private int hit;
    private Date notice_date;
    private String category;
    private String f_name;
    private String answer;
    private char open;
}
