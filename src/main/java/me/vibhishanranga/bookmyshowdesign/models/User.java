package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;

@Entity
public class User extends BaseModel{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
