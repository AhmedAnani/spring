package com.example.test.repository;

import com.example.test.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface emplyecrud extends JpaRepository<Employees,Integer> {
    List<Employees>findByFirstName(String name);
}
