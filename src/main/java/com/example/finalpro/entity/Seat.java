package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "seat")
public class Seat {
    @Id
    private int seatId;
    private String placeId;
    private int ticketId;
    private String seatName;
    private String check_seat;
}
