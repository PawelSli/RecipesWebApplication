package com.github.pawelsli.recipeswebapplication.controllers;


import com.github.pawelsli.recipeswebapplication.entity.User;
import com.github.pawelsli.recipeswebapplication.service.UserService;
import com.github.pawelsli.recipeswebapplication.service.UserServiceImpl;
import com.github.pawelsli.recipeswebapplication.service.dto.UserLoginDTO;
import com.github.pawelsli.recipeswebapplication.service.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
class MainController {

    @Autowired
    private UserService userService;

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
        userService.createUser(userRegisterDTO);
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
