package com.example.BookingSystem.Model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Data
@Entity
@Table(name = "events")
public class EventModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int eventId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String location;

    @Column(name ="event_date" )
    private String eventDate;

    @Column(name = "total_seats")
    private String totalSeats;

    @Column(name = "available_seats")
    private String availableSeats;

    @Column
    private long price;

}
