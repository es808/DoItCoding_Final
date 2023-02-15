package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "draw")
public class Draw {
    @Id
    private int drawid;
    private int ticketid;
    private String custid;
    private int seatid;
}
