package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Repositry.EventCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
   private EventCrud crud;

    //fun for saving the event
    public ResponseEntity<String> addEvent(EventModel eventModel) {
        try {
            crud.save(eventModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Event Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
        }
    }

    public List<EventModel> findAllEvents(){
        try {
            return crud.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseEntity<String> updateByEventId(int eventId,EventModel model) {
        EventModel event = crud.getById(eventId);
        try {
            if (event == null) return ResponseEntity.ok("Event Not Found");
            else {
                event.setTitle(model.getTitle());
                event.setDescription(model.getDescription());
                event.setLocation(model.getLocation());
                event.setEventDate(model.getEventDate());
                event.setTotalSeats(model.getTotalSeats());
                event.setAvailableSeats(model.getAvailableSeats());
                event.setPrice(model.getPrice());
                event.setUpdatedAt(LocalDateTime.now());
                event.setUpdatedBy(model.getUpdatedBy());
                addEvent(event);
                return ResponseEntity.ok("Event Updated Successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
        }

    }
    public  EventModel findById(int id){
        try {
            return crud.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> deleteEventById(int id){
            try {
            crud.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Event Deleted Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
