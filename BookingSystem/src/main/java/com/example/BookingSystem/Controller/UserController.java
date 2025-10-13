package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Service.BookingService;
import com.example.BookingSystem.Service.UserService;
import com.example.BookingSystem.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController

public class UserController implements UserApi {
    @Autowired
   private UserService service;



    public ResponseEntity<String> saveUser( UserModel model){

           return service.saveUser(model);
    }


    public List<UserModel> getAllUsers(){
        return service.getAllUsers();
    }


    public UserModel findById( int  id){
      return service.getById(id);
    }


    public ResponseEntity<String> updateUserById( int id, UserModel model){
    return service.updateUserById(id, model);
    }


    public BookingModel FindMyBookings( int userId){

            return service.findMyBookings(userId);

    }


    public ResponseEntity<String> deleteUserById( int id){
        return service.deletById(id);
    }

}
