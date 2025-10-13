package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCrud extends JpaRepository<EventModel,Integer> {

  void deleteById(int id);
}
