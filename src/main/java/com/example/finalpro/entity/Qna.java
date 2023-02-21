package com.example.finalpro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "qna")
public class Qna {
    @Id
    private int qna_no;
    @ManyToOne
    @JoinColumn(name = "ticketid", insertable = true, updatable = true)
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "custid", insertable = true, updatable = true)
    private Customer customer;
    private String qna_title;
    private String qna_content;
    private int qna_hit;
    private Date qna_date;
    private String qna_category;
    private String qna_fname;
    private String qna_answer;
    private char qna_open;
}
