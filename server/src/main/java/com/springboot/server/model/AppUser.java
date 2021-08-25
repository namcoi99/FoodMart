package com.springboot.server.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="USER",uniqueConstraints={@UniqueConstraint(columnNames={"email","username"})})
public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long userID;
    @NotNull
    private String email;
    @Column(nullable = false, updatable = false)
    private String username;
    @NotNull
    private String password;

    public AppUser() {}

    public AppUser(Long userID, String email, String username, String password) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
