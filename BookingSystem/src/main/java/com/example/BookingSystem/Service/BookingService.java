package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.BookingModel;
import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Repositry.BookingCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BookingService {

    private final BookingCrud bookingCrud;

    private final EventService eventService;

    private final UserService userService;

    @Autowired
    public BookingService(BookingCrud bookingCrud,EventService eventService,UserService userService){
        this.bookingCrud=bookingCrud;
        this.eventService=eventService;
        this.userService=userService;
    }

    public ResponseEntity<String>  saveBooking(BookingModel bookingModel){

        try {
            // For Handling Available Seats
            EventModel event= eventService.findById(bookingModel.getEventId());
            if(event.getAvailableSeats()<bookingModel.getNumberOfTicket()){
                return ResponseEntity.ok("There's NO Enough Tickets");
            }else {
                event.setAvailableSeats(event.getAvailableSeats() - bookingModel.getNumberOfTicket());
                bookingModel.setBookingDate(LocalDateTime.now());
                bookingModel.setCreatedAt(LocalDateTime.now());
                bookingModel.setTotalPrice(event.getPrice()*bookingModel.getNumberOfTicket());
                bookingCrud.save(bookingModel);
                return ResponseEntity.status(HttpStatus.CREATED).body("Booking Saved Successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }


    public List<BookingModel> getAllBookings(){
       try {
           return bookingCrud.findAll();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    public BookingModel findById(int id){
        try{
            return bookingCrud.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> deleteBookingById(int id){
        try {
            BookingModel booking=bookingCrud.findByUserId(id);
            int numT=booking.getNumberOfTicket();
            int eventId=booking.getEventId();
            EventModel event= eventService.findById(eventId);
            event.setAvailableSeats(event.getAvailableSeats()+numT);
             bookingCrud.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Booking Canceled Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }

    public ResponseEntity<String> updateBookingByUserId(int userId,BookingModel model){
       try {
           BookingModel booking = bookingCrud.findByUserId(userId);
           UserModel user = userService.getById(userId);
           EventModel event = eventService.findById(booking.getEventId());
           if (event.getAvailableSeats() < model.getNumberOfTicket()) {
               return ResponseEntity.ok("There's NO Enough Tickets");
           } else {
               booking.setUpdatedAt(LocalDateTime.now());
               booking.setUpdatedBy(user.getFirstName() + user.getLastName());
               booking.setNumberOfTicket(model.getNumberOfTicket());
               booking.setTotalPrice(event.getPrice() * model.getNumberOfTicket());
               bookingCrud.save(booking);
               return ResponseEntity.ok("Updated Successfully");
           }
       } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()) ;
       }
    }

}
