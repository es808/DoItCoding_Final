package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    private int reviewId;
    private String custId;
    private int ticketId;
    private int score;
    private String review_content;
}
