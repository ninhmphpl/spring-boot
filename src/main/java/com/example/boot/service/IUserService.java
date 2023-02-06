package com.example.boot.service;

import com.example.boot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    public Optional<User> findByUsername(String username);
}
