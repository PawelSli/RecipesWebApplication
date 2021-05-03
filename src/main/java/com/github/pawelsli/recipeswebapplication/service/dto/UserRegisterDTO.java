package com.github.pawelsli.recipeswebapplication.service.dto;

import com.sun.istack.NotNull;
import lombok.experimental.NonFinal;

import java.util.Set;

public class UserRegisterDTO {
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
