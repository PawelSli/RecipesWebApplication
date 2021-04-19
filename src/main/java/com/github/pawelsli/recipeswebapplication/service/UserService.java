package com.github.pawelsli.recipeswebapplication.service;


import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User findUserByEmail(String email);
    User createUser(UserRegisterDTO registerDTO);
}
