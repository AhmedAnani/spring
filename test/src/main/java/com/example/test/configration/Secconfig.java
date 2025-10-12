package com.example.test.configration;

import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Secconfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http.csrf(c->c.disable()).authorizeHttpRequests(auth->auth
        .requestMatchers("/employee/**").hasRole("Admin")
        .requestMatchers("/user/getid/**").hasRole("Admin")
        .requestMatchers("/user/getname/**").permitAll().anyRequest().permitAll());

    return  http.build();

    }
@Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
}
}
