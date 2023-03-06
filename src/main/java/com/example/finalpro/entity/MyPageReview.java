package com.example.finalpro.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class MyPageReview {
    //JPA는 테이블 속성명과 엔티티의 변수명을 똑같이해야 인식함.
    @Id
    private int reviewid;
    @ManyToOne
    @JoinColumn(name="custid", insertable = true, updatable = true)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="ticketid", insertable = true, updatable = true)
    private Ticket ticket;
    private int score;
    private String review_content;
}
