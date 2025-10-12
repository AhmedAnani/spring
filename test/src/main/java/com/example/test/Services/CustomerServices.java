package com.example.test.Services;

import com.example.test.Model.Customers;
import com.example.test.configration.Secconfig;
import com.example.test.repository.customercrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    @Autowired
    private  customercrud customercrud;
    @Autowired
    private Secconfig passwordencoder;

    public List<Customers> getallcustomers(){
        return customercrud.findAll();
    }
    public void saveemp(Customers customers){

            customercrud.save(customers);
    }
    public Optional<Customers> getById(int id){
        return customercrud.findById(id);
    }

    public List<Customers>getByName(String name){
        return customercrud.findByFirstName(name);
    }
}
