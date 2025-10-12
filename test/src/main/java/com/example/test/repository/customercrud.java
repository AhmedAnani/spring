package com.example.test.repository;

import com.example.test.Model.Customers;
import com.example.test.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface customercrud extends JpaRepository<Customers,Integer> {
    List<Customers> findByFirstName(String name);
}
