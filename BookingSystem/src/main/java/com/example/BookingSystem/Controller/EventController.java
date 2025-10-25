package com.example.BookingSystem.Controller;

import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Service.EventService;
import com.example.BookingSystem.api.EventApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventController implements EventApi {
    @Autowired
    private EventService service;


    public ResponseEntity<String> addEvent(EventModel model){return service.addEvent(model);}


    public Page<EventModel> getAllEvents(int page, int size){
        return service.findAllEvents(page,size);
    }


    public EventModel findById( int eventId){return service.findById(eventId);}


    public ResponseEntity<String> updateEvent( int eventId,  EventModel model){
        return service.updateByEventId(eventId,model);
    }


    public ResponseEntity<String> deleteEventById( int eventId){
      return service.deleteEventById(eventId);
    }


}
