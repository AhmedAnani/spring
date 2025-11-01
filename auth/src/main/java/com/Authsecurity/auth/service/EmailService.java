package com.Authsecurity.auth.service;

import com.Authsecurity.auth.model.UserModle;
import com.Authsecurity.auth.repositry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    private final UserRepo repo;

    public ResponseEntity<?> sendOtp(String email){
            try {
                Optional<UserModle> modle= repo.findByEmail(email);
                if(email.equals(modle.get().getEmail())) {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setTo(email);
                    message.setSubject("Your OTP ");
                    message.setText("Your OTP is: " + generateOtp() + " Valid for 5 minutes");
                    javaMailSender.send(message);
                    return ResponseEntity.status(HttpStatus.OK).body("Mail Send Successfully");

                }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Not Found");
            } catch (Exception e) {
              return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
            }
    }

    private String generateOtp(){
        int otp = 100000 + new Random().nextInt(900000);
        return String.valueOf(otp);
    }
}
