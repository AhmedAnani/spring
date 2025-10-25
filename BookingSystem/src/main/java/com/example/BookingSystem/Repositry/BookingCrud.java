package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.BookingModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {
    BookingModel findByUserId(int id);

    void deleteById(int id);

    @Query(name="SELECT * FROM bookings ORDER BY booking_date ASC", nativeQuery = true)
    Page<BookingModel> findAllByOrderByBookingDateAsc(Pageable pageable);
}
