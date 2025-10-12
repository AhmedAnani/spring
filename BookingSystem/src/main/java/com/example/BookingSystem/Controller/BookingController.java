package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
   private BookingService service;

    @PostMapping("/save")
    private String saveBooking(@RequestBody BookingModel model){
        try {
            service.saveBooking(model);
            return "Saved The Booking Successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("/getAll")
    private List<BookingModel> getAllBookings(){
        return service.getAllBookings();
    }


}
