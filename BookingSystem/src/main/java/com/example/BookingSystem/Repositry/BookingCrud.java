package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {
BookingModel findByUserId(int id);
void deleteById(int id);
}
