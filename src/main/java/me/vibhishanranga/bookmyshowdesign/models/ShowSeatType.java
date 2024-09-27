package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends  BaseModel{
    // 1 ShowSeatType -> 1 Show
    // M ShowSeatTypes -> 1 Show
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
