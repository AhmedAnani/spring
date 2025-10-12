package com.example.test.Controller;

import com.example.test.Model.Customers;
import com.example.test.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    private CustomerServices customerServices;
    @GetMapping("/all")
    private   List<Customers> getemp(){
        return customerServices.getallcustomers();
    }
    @PostMapping("/add")
    private String postcustomer(Customers customers){
        try {
            customerServices.saveemp(customers);
            return "customer Saved ";
        } catch (Exception e){
            return e.toString();
        }
    }
    @GetMapping("/getid/{id}")
    private Optional<Customers> getId(@PathVariable int id){
        return   customerServices.getById(id);
    }
    @GetMapping("/getname/{name}")
    private List<Customers>getname(@PathVariable String name){
        return customerServices.getByName(name);
    }
}
