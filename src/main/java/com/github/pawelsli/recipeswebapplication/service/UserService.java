package com.github.pawelsli.recipeswebapplication.service;

import com.github.pawelsli.recipeswebapplication.entity.User;

import java.util.Optional;

public interface UserService {
    public abstract Optional<User> findUserByEmail(String email);
    public abstract void createUser(User user);
}
