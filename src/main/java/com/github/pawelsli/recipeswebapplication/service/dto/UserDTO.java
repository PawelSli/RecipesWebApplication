package com.github.pawelsli.recipeswebapplication.service.dto;

import com.github.pawelsli.recipeswebapplication.entity.User;

public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String phone;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User convertToUser(){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setUsername(username);
        user.setPhone(phone);
        user.setImage(image);
        return user;
    }
}
