package com.github.pawelsli.recipeswebapplication.entity;

//import javax.persistence.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false,unique=true)
    private Long id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Recipe> recipeList;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime jointAt;

    @Column(name = "username")
    private String username;


    @Column(name = "phone")
    private String phone;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Set<Role> roles = new HashSet<>();

    public User(){
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password,
                Set<Role> roles, LocalDateTime jointAt, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.jointAt=jointAt;
        this.phone=phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public void setRoles(Set<Role> roles) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
