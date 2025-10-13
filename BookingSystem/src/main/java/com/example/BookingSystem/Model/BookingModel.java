package com.example.BookingSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "bookings")
public class BookingModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "event_id")
    private int eventId;
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;
    @Column(name = "number_of_ticket")
    private int numberOfTicket;
    @Column(name = "total_price")
    private long totalPrice;
}
