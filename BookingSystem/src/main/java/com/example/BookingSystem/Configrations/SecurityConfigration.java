package com.example.BookingSystem.Configrations;


import com.example.BookingSystem.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Custom Authentication & Authorization
@Configuration
public class SecurityConfigration {

    @Autowired
   private CustomUserDetailsService service;
    // Get User (Email,Password) From DataBase To Check His Role
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    // Convert Password To Hash Password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //Custom Authorization
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(c->c.disable())
        .authorizeHttpRequests(auth->auth.requestMatchers("/event/**").hasAnyRole("Admin","ADMIN")
                .requestMatchers("/user/**").hasAnyRole("Admin","ADMIN")
                .requestMatchers("/booking/**").hasAnyRole("Admin","ADMIN")
                .requestMatchers("/event/getAll").permitAll()
                .requestMatchers("/user/myProfile").hasAnyRole("User","USER","Admin","ADMIN")
                .requestMatchers("/user/booking/myBooking").hasAnyRole("User","USER")
        )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();


    }
}
