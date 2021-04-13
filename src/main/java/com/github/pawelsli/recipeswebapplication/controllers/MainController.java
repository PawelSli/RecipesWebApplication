package com.github.pawelsli.recipeswebapplication.controllers;


import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.entity.UserDetails;
import com.github.pawelsli.recipeswebapplication.repository.UserRepository;
import com.github.pawelsli.recipeswebapplication.service.UserDetailsService;
import com.github.pawelsli.recipeswebapplication.service.UserServiceImpl;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
class MainController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/addDish")
    public String addDish(){
        return "add-dish";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userRegisterDTO",new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(UserRegisterDTO userRegisterDTO){
        User user =new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setJointAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));


        UserDetails userDetails=new UserDetails();
        userDetails.setName(userRegisterDTO.getName());
        userDetails.setSurname(userRegisterDTO.getSurname());
        userDetails.setPhone(Long.parseLong(userRegisterDTO.getPhone()));
        userDetails.setUser(user);
        user.setUserDetails(userDetails);

        userService.createUser(user);
        userDetailsService.createUserDetails(userDetails);
        return "login";

    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }


    @GetMapping("/main")
    public String mainPage(Model model){
        return "index";
    }



    @GetMapping("/dish")
    public String showDish(Model model){
        return "dish";
    }





    @GetMapping("/search")
    public String search(Model model){
        return "search";
    }

}
