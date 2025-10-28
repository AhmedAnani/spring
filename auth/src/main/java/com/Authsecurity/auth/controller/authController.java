package com.Authsecurity.auth.controller;

import com.Authsecurity.auth.api.authApi;
import com.Authsecurity.auth.model.UserModle;
import com.Authsecurity.auth.service.jwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


public class authController implements authApi {


    private final AuthenticationManager authenticationManager;


     private final jwtService jwtService;


    private final UserDetailsService userDetailsService;

    @Autowired
    public authController(AuthenticationManager authenticationManager, jwtService jwtService, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public ResponseEntity<String> createToken(UserModle userModle ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userModle.getEmail(), userModle.getPassword())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(userModle.getEmail());
            final String jwt = jwtService.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Not Found");
        }
    }

    public  ResponseEntity<String> check(){
        try{
            return ResponseEntity.ok("checked");
        } catch (Exception e) {
          return ResponseEntity.ok(  new RuntimeException(e).toString());
        }

    }

}
