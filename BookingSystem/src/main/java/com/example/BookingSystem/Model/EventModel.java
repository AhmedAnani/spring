package com.example.BookingSystem.Model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
@Table(name = "events")
public class EventModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String location;

    @Column(name ="event_date" )
    private Date eventDate;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "available_seats")
    private int availableSeats;

    @Column
    private long price;

}
