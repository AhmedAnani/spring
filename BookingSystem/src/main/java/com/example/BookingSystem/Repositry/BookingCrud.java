package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {
List<BookingModel>foundByUserId(int id);
}
