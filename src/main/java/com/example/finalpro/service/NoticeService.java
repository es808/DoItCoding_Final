package com.example.finalpro.service;

import com.example.finalpro.dao.NoticeDAO;
import com.example.finalpro.entity.Notice;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class NoticeService {

    @Autowired
    private NoticeDAO dao;

    public List<Notice> findAll(){return dao.findAll();}
}
