package com.example.BookingSystem.Service;

import com.example.BookingSystem.Model.UserModel;
import com.example.BookingSystem.Repositry.UserCrud;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCrud crud;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = crud.findByEmail(email);
        try {
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }



    }
}
