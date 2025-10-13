package com.example.BookingSystem.api;

import com.example.BookingSystem.Model.BookingModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookings")
public interface BookingApi {

    // Add New User
    @PostMapping
     ResponseEntity<String> saveBooking(@RequestBody BookingModel model);

    // Get All Bookings
    @GetMapping
     List<BookingModel> getAllBookings();

    // Find Bookings By Booking Id
    @GetMapping("/{id}")
     BookingModel findById(@PathVariable int id);

    // Delete Booking By User Id
    @DeleteMapping("/{id}")
     ResponseEntity<String> deleteBooking(@RequestParam int userId);

    //Update Booking By User
    @PutMapping("/{id}")
     ResponseEntity<String> updateBookingByUserId( int id, BookingModel bookingModel);
}
