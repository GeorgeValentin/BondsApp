package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public User(){}

    public User(int userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
    }

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.password = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
