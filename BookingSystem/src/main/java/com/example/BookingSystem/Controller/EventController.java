package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService service;
    //Add Event
    @PostMapping("/add")
    private String addEvent(@RequestBody EventModel model){
        try {
            service.addEvent(model);
            return "Event Saved Successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }

    //Get All Events
    @GetMapping("/getAll")
    private List<EventModel> getAllEvents(){
        return service.findAllEvents();
    }

    //Found The Event By EventTitle
    @GetMapping("/getEvent")
    private EventModel findByTitle(@RequestParam String title){
        try {

           return service.findByEventTitle(title);
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
    }

    //Found Event BY EventTitle For Updating
    @PutMapping("/updateEvent")
    private ResponseEntity<String> updateEvent(@RequestParam String title, @RequestBody EventModel model){
        var event=service.updateByEventTitle(title);
        if (event==null)return  ResponseEntity.ok("Event Not Found");
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
        service.addEvent(event);
        return ResponseEntity.ok("Event Updated Successfully");
        }
    }


}
