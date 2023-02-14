package com.example.finalpro.dao;

import com.example.finalpro.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestDAO extends JpaRepository<Category, Integer> {
}
