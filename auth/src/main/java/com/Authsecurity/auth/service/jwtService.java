package com.Authsecurity.auth.service;

import com.Authsecurity.auth.model.UserModle;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class jwtService {


    private static final String key="89bfce59677de4307cd2f29be25b3ffecfdbdc6368e717f77cf2be948ecc0725";


public String generateToken(String username){
     return Jwts
             .builder()
             .setSubject(username)
             .setIssuedAt(new Date(System.currentTimeMillis()))
             .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
             .signWith( getSigningKey(),SignatureAlgorithm.HS256)
             .compact();
 }



    public boolean validateToken(String token, UserDetails userDetails){
    String extractEmail=extractEmail(token);
        return extractEmail.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
    Date expiration =Jwts.parser()
            .setSigningKey(getSigningKey())
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
    return expiration.before(new Date());
    }

    //extract email from jwt token
    public String extractEmail(String token){
     return Jwts
             .parser()
             .setSigningKey(getSigningKey())
             .parseClaimsJws(token)
             .getBody()
             .getSubject();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
