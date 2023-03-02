package com.example.finalpro.controller;

import com.example.finalpro.dao.CustomerDAO;
import com.example.finalpro.db.DBManager;
import com.example.finalpro.vo.CustomerVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Setter
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/FindCustomer")
    @ResponseBody
    public CustomerVO findCustomer(String custid){
        return DBManager.findByCustid(custid);
    }

}
