package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.EventModel;
import com.example.BookingSystem.Repositry.EventCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
   private EventCrud crud;

    //fun for saving the event
    public void addEvent(EventModel eventModel) {
        crud.save(eventModel);
    }

    public List<EventModel> findAllEvents(){
        return crud.findAll();
    }

    public EventModel findByEventTitle(String title){
       return crud.findByTitle(title);
    }
    public EventModel updateByEventTitle(String title){
        return crud.findByTitle(title);
    }
}
