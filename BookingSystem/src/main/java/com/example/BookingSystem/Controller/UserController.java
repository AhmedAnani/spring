package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Service.BookingService;
import com.example.BookingSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService service;
    @Autowired
    private BookingService bookingService;

    //Save User
    @PostMapping("/save")
    private ResponseEntity<String> saveUser(@RequestBody UserModel model){
        try {
            service.saveUser(model);
            return ResponseEntity.ok("User Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    //Get All Users
    @GetMapping("/getAll")
    private List<UserModel> getAllUsers(){
        return service.getAllUsers();
    }

    //Found User By UserEmail
    @GetMapping("/myProfile")
    private UserModel findByEmail(@RequestParam String email){
      return   service.findByEmail(email);
    }

    //Found User By UserId and Updated
    @PutMapping("/updateUser")
    private ResponseEntity<String> updateUserById(@RequestParam int id, @RequestBody UserModel model){
        try {
          UserModel user=  service.getById(id);
          if (user==null){
              return ResponseEntity.ok("User Not Found");
          }else {

              user.setFirstName(model.getFirstName());
              user.setLastName(model.getLastName());
              user.setPassword(model.getPassword());
              user.setRole(model.getRole());
              user.setUpdatedBy(model.getUpdatedBy());
              user.setUpdatedAt(LocalDateTime.now());

              service.saveUser(user);

              return ResponseEntity.ok("User Updated Successfully ");
          }
        } catch (Exception e) {
            return ResponseEntity.ok(e.toString());
        }
    }

    @GetMapping("/myBooking")
    private List<BookingModel> FoundMyBookings(@RequestParam int userId){
        try {
            return bookingService.foundByUserId( userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
