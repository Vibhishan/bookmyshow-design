package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;

    private String address;

    // 1 Theatre -> M Auditorium
    // 1 Theatre -> 1 Auditorium
    @OneToMany (mappedBy = "theatre")
    private List<Auditorium> auditoriums;

    // 1 Theatre -> M Shows
    // 1 Theatre <- 1 Show
    @OneToMany
    private List<Show> upcomingShows;
}
