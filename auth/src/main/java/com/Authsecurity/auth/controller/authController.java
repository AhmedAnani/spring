package com.Authsecurity.auth.controller;

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

@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
     private jwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<String> createToken(@RequestBody UserModle userModle ) {
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
    @GetMapping("/ch")
    public  ResponseEntity<String> check(){
try{
    return ResponseEntity.ok("checked");
} catch (Exception e) {
  return ResponseEntity.ok(  new RuntimeException(e).toString());
}

    }

}
