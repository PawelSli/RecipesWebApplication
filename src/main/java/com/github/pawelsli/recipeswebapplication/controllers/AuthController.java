package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.service.UserService;
import com.github.pawelsli.recipeswebapplication.service.dto.JwtResponse;
import com.github.pawelsli.recipeswebapplication.service.dto.MessageResponse;
import com.github.pawelsli.recipeswebapplication.service.dto.UserLoginDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Validated @RequestBody UserLoginDTO loginRequest) {
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());
        JwtResponse jwtResponse=userService.authenticateUser(loginRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Validated @RequestBody UserRegisterDTO signUpRequest) {
        MessageResponse messageResponse=userService.registerUser(signUpRequest);

        if(messageResponse.containError()){
            return ResponseEntity.badRequest().body(messageResponse);
        }else{
            return ResponseEntity.ok(messageResponse);
        }
    }
}
