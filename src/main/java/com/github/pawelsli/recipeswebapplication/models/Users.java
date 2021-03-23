package com.github.pawelsli.recipeswebapplication.models;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
class Users {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column(columnDefinition = "email")
    private String email;
    //@Column(columnDefinition = "password")
    private String password;
    //@Column(columnDefinition = "created_at")
    private LocalDateTime created_at;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
