package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Repositry.BookingCrud;
import com.example.BookingSystem.Repositry.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final  UserCrud crud;
    private final  BookingCrud bookingCrud;
    @Autowired
    public UserService(UserCrud crud, BookingCrud bookingCrud){
        this.crud=crud;
        this.bookingCrud=bookingCrud;
    }





    public ResponseEntity<String> saveUser(UserModel model){
        try {
            crud.save(model);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Saved Successfully");
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
    }

    public List<UserModel> getAllUsers(){
        try {
            return crud.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public UserModel getById(int id){

        try {
            return crud.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> deletById(int id){
        try {
            crud.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    public ResponseEntity<String> updateUserById(int id,UserModel model){
        try {
            UserModel user=  crud.getById(id);
            if (user==null){
                return ResponseEntity.ok("User Not Found");
            }else {

                user.setFirstName(model.getFirstName());
                user.setLastName(model.getLastName());
                user.setPassword(model.getPassword());
                user.setRole(model.getRole());
                user.setUpdatedBy(model.getUpdatedBy());
                user.setUpdatedAt(LocalDateTime.now());
                crud.save(user);
                return ResponseEntity.ok("User Updated Successfully ");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    public BookingModel findMyBookings(int id){
      try {
          return bookingCrud.findByUserId(id);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
    }
}
