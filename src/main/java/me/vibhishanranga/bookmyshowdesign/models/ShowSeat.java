package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
    // 1 ShowSeat -> 1 Show
    // M ShowSeats -> 1 Show
    @ManyToOne
    private Show show;

    // 1 ShowSeat -> 1 Seat
    // M ShowSeats -> 1 Seat
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatState state;
}
