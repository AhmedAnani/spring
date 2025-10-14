package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Service.EventService;
import com.example.BookingSystem.api.EventApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EventController implements EventApi {
    @Autowired
    private EventService service;


    public ResponseEntity<String> addEvent(EventModel model){return service.addEvent(model);}


    public List<EventModel> getAllEvents(){
        return service.findAllEvents();
    }


    public EventModel findById( int eventId){return service.findById(eventId);}


    public ResponseEntity<String> updateEvent( int eventId,  EventModel model){
        return service.updateByEventId(eventId,model);
    }


    public ResponseEntity<String> deleteEventById( int eventId){
      return service.deleteEventById(eventId);
    }


}
