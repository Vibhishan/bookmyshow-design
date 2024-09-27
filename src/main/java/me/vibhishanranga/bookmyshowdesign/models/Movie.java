package me.vibhishanranga.bookmyshowdesign.models;

import java.util.List;

public class Movie extends BaseModel{
    private String name;
    private List<Language> languages;
    private List<Actor> actors;
    private int length;
    private double rating;
    private List<MovieFeature> movieFeatures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<MovieFeature> getMovieFeatures() {
        return movieFeatures;
    }

    public void setMovieFeatures(List<MovieFeature> movieFeatures) {
        this.movieFeatures = movieFeatures;
    }
}
