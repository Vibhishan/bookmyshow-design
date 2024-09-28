package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// we change table name because postgres does not allow the creation of a table named user
@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
