package com.example.finalpro.dao;

import com.example.finalpro.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceDAO extends JpaRepository<Place, String> {
}
