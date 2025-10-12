package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Repositry.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
  private UserCrud crud;
    @Autowired
    private CustomUserDetailsService service;

    public void saveUser(UserModel model){
        crud.save(model);
    }

    public List<UserModel> getAllUsers(){
        return crud.findAll();
    }

    public UserModel findByEmail(String email){
        return crud.findByEmail(email);
    }

    public UserModel getById(int id){
        return crud.getById(id);
    }



}
