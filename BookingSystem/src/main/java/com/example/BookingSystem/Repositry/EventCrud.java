package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.EventModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventCrud extends JpaRepository<EventModel,Integer> {

  void deleteById(int id);
    @Query(value = "SELECT * FROM events  ORDER  BY total_seats DESC",nativeQuery = true)
    Page<EventModel> findAllByOrderByTotalSeatsDesc(Pageable pageable);

}
