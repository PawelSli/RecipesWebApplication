package com.github.pawelsli.recipeswebapplication.entity;

//import javax.persistence.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false,unique=true)
    private long id;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipeList;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime jointAt;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection < Role > roles;

    public User(){}

    public User(String name, String surname, String email, String password,
                Collection < Role > roles, LocalDateTime jointAt, String phone,String image) {
        super();
        this.name=name;
        this.surname=surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.jointAt=jointAt;
        this.phone=phone;
        this.image=image;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
