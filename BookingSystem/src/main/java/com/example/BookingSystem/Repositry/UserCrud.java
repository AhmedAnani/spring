package com.example.BookingSystem.Repositry;

import com.example.BookingSystem.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCrud extends JpaRepository<UserModel,Integer> {
    UserModel findByEmail(String mail);

}
