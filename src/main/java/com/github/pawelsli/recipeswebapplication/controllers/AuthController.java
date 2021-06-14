package com.github.pawelsli.recipeswebapplication.controllers;

import com.github.pawelsli.recipeswebapplication.security.UserDetailsImpl;
import com.github.pawelsli.recipeswebapplication.service.UserService;
import com.github.pawelsli.recipeswebapplication.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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
        JwtResponse jwtResponse = userService.authenticateUser(loginRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Validated @RequestBody UserRegisterDTO signUpRequest) {
        MessageResponse messageResponse = userService.registerUser(signUpRequest);

        if (messageResponse.containError()) {
            return ResponseEntity.badRequest().body(messageResponse);
        } else {
            return ResponseEntity.ok(messageResponse);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return  ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteUser(@RequestParam String email){
        return ResponseEntity.ok(userService.deleteUser(email));
    }

}
