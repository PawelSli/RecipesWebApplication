package com.github.pawelsli.recipeswebapplication.controllers;


import com.github.pawelsli.recipeswebapplication.entity.Users;
import com.github.pawelsli.recipeswebapplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
class MainController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewUser (@RequestBody @Validated Users users) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        usersRepository.save(users);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return usersRepository.findAll();
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        return "index";
    }

    @GetMapping("/addDish")
    public String addDish(Model model){
        return "add-dish";
    }

    @GetMapping("/dish")
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
