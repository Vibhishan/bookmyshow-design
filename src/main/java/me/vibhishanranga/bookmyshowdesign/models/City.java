package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;

    // 1 City -> M Theatres
    // 1 Theatre -> 1 City
    @OneToMany
    private List<Theatre> theatres;
}
