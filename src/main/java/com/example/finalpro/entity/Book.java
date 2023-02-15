package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    private int bookId;
    private String custId;
    private int ticketId;
    private int seatId;
}
