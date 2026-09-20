package com.nhlstenden.appstores;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String username;
    private String email;
    private LocalDate birthDate;

    public User(String username, String email, LocalDate birthDate) {
        this.username = username;
        this.setEmail(email);
        this.birthDate = birthDate;
    }

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
        this.email = Validation.validateEmail(email) ? email : null;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
