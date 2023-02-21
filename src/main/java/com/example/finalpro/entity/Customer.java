package com.example.finalpro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    //JPA는 테이블 속성명과 엔티티의 변수명을 똑같이해야 인식함.
    @Id
    private String custid;
    private String pwd;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String gender;
    private int cateid;
}
