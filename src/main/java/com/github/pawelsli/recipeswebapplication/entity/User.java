package com.github.pawelsli.recipeswebapplication.entity;

//import javax.persistence.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;
    @OneToMany(mappedBy = "user")
    private List<Recipe> recipeList;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdetails_id")
    private UserDetails userDetails;
    private String email;
    private String password;
    private LocalDateTime jointAt;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getJointAt() {
        return jointAt;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJointAt(LocalDateTime jointAt) {
        this.jointAt = jointAt;
    }

}
