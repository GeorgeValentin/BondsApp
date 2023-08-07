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

    @Column(name = "user_password_hash")
    private String userPasswordHash;

    @Column(name = "user_password_salt")
    private String userPasswordSalt;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public User(){}

    public User(int userId, String userEmail, String password) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
    }

    public User(int userId, String userEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
    }
    public User(int userId, String userEmail, String userPasswordHash, String userPasswordSalt) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPasswordHash = userPasswordHash;
        this.userPasswordSalt = userPasswordSalt;
    }

    public User(String userEmail, String userPasswordHash, String userPasswordSalt) {
        this.userEmail = userEmail;
        this.userPasswordHash = userPasswordHash;
        this.userPasswordSalt = userPasswordSalt;
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

    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    public String getUserPasswordSalt() {
        return userPasswordSalt;
    }

    public void setUserPasswordSalt(String userPasswordSalt) {
        this.userPasswordSalt = userPasswordSalt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPasswordHash='" + userPasswordHash + '\'' +
                ", userPasswordSalt='" + userPasswordSalt + '\'' +
                '}';
    }
}
