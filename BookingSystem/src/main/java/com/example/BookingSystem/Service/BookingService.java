package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Repositry.BookingCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {
    @Autowired
    private BookingCrud bookingCrud;

    public void  saveBooking(BookingModel bookingModel){
        bookingCrud.save(bookingModel);
    }

    public List<BookingModel> getAllBookings(){
        return bookingCrud.findAll();
    }

    public BookingModel foundById(int id){
        return bookingCrud.getById(id);
    }
    public List<BookingModel> foundByUserId(int userId){
        return bookingCrud.foundByUserId(userId);
    }

}
