package com.example.test.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customers extends BaseEntity {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "mobile_num", nullable = false, length = 11)
    private String mobileNum;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "balance")
    private double balance;
}
