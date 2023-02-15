package com.example.finalpro.dao;

import com.example.finalpro.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatDAO extends JpaRepository<Seat, Integer> {
}
