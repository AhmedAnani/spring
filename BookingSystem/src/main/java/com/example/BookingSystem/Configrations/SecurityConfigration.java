package com.example.BookingSystem.Configrations;


import com.example.BookingSystem.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
        .authorizeHttpRequests(auth->auth

                // Public Access
                .requestMatchers(HttpMethod.POST,"/users").permitAll()
                .requestMatchers(HttpMethod.GET,"/events").permitAll()
                .requestMatchers(HttpMethod.GET,"/swagger-ui/index.html").permitAll()
                .requestMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
                .requestMatchers(HttpMethod.GET,"/v3/api-docs").permitAll()

                // Admin Access
                .requestMatchers(HttpMethod.GET,"/users").hasRole("Admin")
                .requestMatchers(HttpMethod.DELETE,"/users/{id}").hasRole("Admin")
                .requestMatchers(HttpMethod.GET,"/users/{id}").hasRole("Admin")
                .requestMatchers(HttpMethod.POST,"/events").hasRole("Admin")
                .requestMatchers(HttpMethod.PUT,"/events/{id}").hasRole("Admin")
                .requestMatchers(HttpMethod.DELETE,"/events/{id}").hasRole("Admin")
                .requestMatchers(HttpMethod.GET,"/bookings").hasRole("Admin")



                // User Access
                .requestMatchers(HttpMethod.PUT,"/users/{id}").hasRole("User")
                .requestMatchers(HttpMethod.GET,"/users/myBookings/{id}").hasRole("User")
                .requestMatchers(HttpMethod.GET,"/events/{id}").hasRole("User")
                .requestMatchers(HttpMethod.POST,"/bookings").hasRole("User")
                .requestMatchers(HttpMethod.DELETE,"/bookings/{id}").hasRole("User")
                .requestMatchers(HttpMethod.PUT,"/bookings/{id}").hasRole("User")
                .requestMatchers(HttpMethod.GET,"/booking/{id}").hasRole("User")

        )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();


    }
}
