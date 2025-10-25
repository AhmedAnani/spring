package com.example.BookingSystem.api;

import com.example.BookingSystem.Model.BookingModel;
import org.springframework.data.domain.Page;
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
    Page<BookingModel> findAllByOrderByBookingDateAsc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size);

    // Find Bookings By Booking Id
    @GetMapping("/{id}")
     BookingModel findById(@PathVariable int id);

    // Delete Booking By User Id
    @DeleteMapping("/{id}")
     ResponseEntity<String> deleteBooking(@PathVariable int userId);

    //Update Booking By User
    @PutMapping("/{id}")
     ResponseEntity<String> updateBookingByUserId(@PathVariable int id, @RequestBody BookingModel bookingModel);

}
