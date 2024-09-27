package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Language> languages;

    // 1 Movie -> M Actors
    // M Movies <- 1 Actor
    // we have used "mappedby" in Actor class to avoid making multiple tables
    @ManyToMany
    private List<Actor> actors;

    private int length;

    private double rating;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
