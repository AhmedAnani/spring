package com.example.test.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "employees")
public class Employees extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @JsonProperty("employee_id")
    private int id;
    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;
    @Column(name = "second_name")
    @JsonProperty("second_name")
    private String secondName;
    @JsonProperty("mobile_num")
    @Column(name = "mobile_num", nullable = false, length = 11)
    private String mobileNum;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "degree")
    private String degree;
    @Column(name = "salary")
    private double salary;
}
