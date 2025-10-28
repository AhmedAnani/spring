package com.Authsecurity.auth.api;

import com.Authsecurity.auth.model.UserModle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public interface authApi {
    @PostMapping("/login")
     ResponseEntity<String> createToken(@RequestBody UserModle userModle );

    @GetMapping("/ch")
      ResponseEntity<String> check();
}
