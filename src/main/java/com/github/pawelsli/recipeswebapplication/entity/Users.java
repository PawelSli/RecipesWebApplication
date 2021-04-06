package com.github.pawelsli.recipeswebapplication.entity;

//import javax.persistence.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable=false,unique=true)
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Recipes> recipesList;

    @OneToOne
    @JoinColumn(name = "usersdetails_id")
    private UsersDetails userDetails;

    private String email;
    private String password;
    private LocalDateTime jointAt;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getJointAt() {
        return jointAt;
    }

    public void setJointAt(LocalDateTime jointAt) {
        this.jointAt = jointAt;
    }
}
