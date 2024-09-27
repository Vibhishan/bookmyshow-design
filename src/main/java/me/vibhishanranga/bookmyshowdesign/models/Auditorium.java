package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    private String name;

    // 1 Auditorium -> M Seats
    // 1 Seat -> 1 Auditorium
    @OneToMany
    private List<Seat> seats;

    private int capacity;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;

    // 1 Auditorium -> 1 Theatre
    // M Auditorium -> 1 Theatre
    @ManyToOne
    private Theatre theatre;
}
