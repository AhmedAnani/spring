package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Service.BookingService;
import com.example.BookingSystem.api.BookingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookingController implements BookingApi {
    @Autowired
     private BookingService service;




    public ResponseEntity<String> saveBooking( BookingModel model){

        return service.saveBooking(model);
    }

    public Page<BookingModel> findAllByOrderByBookingDateAsc(int page,int size){
        return service.getAllBookingsOrderByBookingDate( page,size);
    }


    public BookingModel findById(int id){

            return service.findById(id);

    }

    public ResponseEntity<String> deleteBooking( int userId){

            return service.deleteBookingById(userId);
    }

    public ResponseEntity<String> updateBookingByUserId( int id,BookingModel bookingModel){
        return service.updateBookingByUserId(id, bookingModel);
    }

}
