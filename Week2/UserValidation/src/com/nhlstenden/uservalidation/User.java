package com.nhlstenden.uservalidation;

import java.time.LocalDate;

public class User {
    private String name;
    private String password;
    private String email;
    private LocalDate dateOfBirth;

    public User(String email, String name, String password, LocalDate dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
