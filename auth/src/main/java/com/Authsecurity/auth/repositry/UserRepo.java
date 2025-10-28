package com.Authsecurity.auth.repositry;

import com.Authsecurity.auth.model.UserModle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModle,Integer> {
    Optional<UserModle> findByEmail(String email);

}
