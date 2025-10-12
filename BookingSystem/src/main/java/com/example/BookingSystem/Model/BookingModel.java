package com.example.BookingSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "bookings")
public class BookingModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    @ManyToMany
    @Column(name = "user_id")
    private int userId;
    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER,mappedBy = "event")
    @Column(name = "event_id")
    private int eventId;
    @Column(name = "booking_date")
    private String bookingDate;
    @Column(name = "number_of_ticket")
    private int numberOfTicket;
    @Column(name = "total_price")
    private long totalPrice;
}
