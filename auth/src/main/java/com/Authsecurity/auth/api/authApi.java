package com.Authsecurity.auth.api;

import com.Authsecurity.auth.model.UserModle;
import org.springframework.http.ResponseEntity;


public interface authApi {

     ResponseEntity<String> createToken(UserModle userModle );
      ResponseEntity<String> check();
}
