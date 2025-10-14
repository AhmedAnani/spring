package com.example.BookingSystem.api;

import com.example.BookingSystem.Model.EventModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//swagger api
//yaml file
@RequestMapping("/events")
public interface EventApi {

    //Add Event
    @PostMapping
    ResponseEntity<String> addEvent(@RequestBody EventModel model);

    //Get All Events
    @GetMapping
     List<EventModel> getAllEvents();

    //Found The Event By EventTitle
    @GetMapping("/{id}")
     EventModel findById(@PathVariable int eventId);

    //Found Event BY EventId For Updating
    @PutMapping("/{id}")
     ResponseEntity<String> updateEvent(@PathVariable int eventId, @RequestBody EventModel model);

    @DeleteMapping("/{id}")
     ResponseEntity<String> deleteEventById(@PathVariable int eventId);
}
