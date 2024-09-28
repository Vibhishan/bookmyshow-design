package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Actor extends BaseModel{
    private String name;

    // annotate with cardinality if the class has an attribute of another class
    // 1 Actor -> M Movies
    // M Actors -> 1 Movie
    @ManyToMany (mappedBy = "actors")
    private List<Movie> movies;

}
