package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.UserDetails;
import com.github.pawelsli.recipeswebapplication.repository.UsersDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UsersDetailRepository usersDetailRepository;

    public Optional<UserDetails> findUserDetailsByUserId(Long id){
        return usersDetailRepository.findByUserId(id);
    }

    public void createUserDetails(UserDetails userDetails){
        usersDetailRepository.save(userDetails);
    }
}
