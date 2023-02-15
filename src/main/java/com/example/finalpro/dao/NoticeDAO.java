package com.example.finalpro.dao;

import com.example.finalpro.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeDAO extends JpaRepository<Notice, Integer> {
}
