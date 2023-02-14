package com.example.finalpro.dao;

import com.example.finalpro.db.DBManager;
import com.example.finalpro.vo.CustomerVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    public List<CustomerVO> findAll() {
        return DBManager.findAll();
    }
}
