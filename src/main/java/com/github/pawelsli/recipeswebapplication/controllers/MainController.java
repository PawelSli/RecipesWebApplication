package com.github.pawelsli.recipeswebapplication.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MainController {

    @GetMapping("/main")
    public String mainPage(Model model){
        return "index";
    }

    @GetMapping("/addDish")
    public String addDish(Model model){
        return "add-dish";
    }

    @GetMapping("/dish/")
    public String showDish(Model model){
        return "dish";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @GetMapping("/search")
    public String search(Model model){
        return "search";
    }

}
