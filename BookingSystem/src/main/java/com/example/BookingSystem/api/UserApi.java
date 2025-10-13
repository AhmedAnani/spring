package com.example.BookingSystem.api;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserApi {

    //Save User
    @PostMapping
     ResponseEntity<String> saveUser(@RequestBody UserModel model);

    //Get All Users
    @GetMapping
     List<UserModel> getAllUsers();

    //Find User By Id
    @GetMapping("/{id}")
     UserModel findById(@PathVariable int  id);

    //Find User By UserId and Update User
    @PutMapping("/{id}")
     ResponseEntity<String> updateUserById(@PathVariable int id, @RequestBody UserModel model);

    // Delete User By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id);

    // Get UserBookings
    @GetMapping("/Bookings/{id}")
    public BookingModel FindMyBookings(@PathVariable int userId);
}
