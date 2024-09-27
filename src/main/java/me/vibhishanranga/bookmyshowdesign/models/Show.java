package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    // 1 Show -> 1 Movie
    // M Shows -> 1 Movie
    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    // 1 Show -> 1 Auditorium
    // 1 Auditorium -> M Shows
    @ManyToOne
    private Auditorium auditorium;

    // 1 Show -> M ShowSeat
    // 1 Show -> 1 ShowSeat
    @OneToMany (mappedBy = "show")
    private List<ShowSeat> showSeats;

    @OneToMany (mappedBy = "show")
    private List<ShowSeatType> showSeatTypes;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;
}
