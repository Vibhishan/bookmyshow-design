package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    // 1 Ticket -> 1 User
    // M Tickets <- 1 User
    @ManyToOne
    private User bookedBy;

    // 1 Ticket -> 1 Show
    // M Tickets <- 1 Show
    @ManyToOne
    private Show show;

    // 1 Ticket -> M ShowSeat
    // M Ticket <- 1 ShowSeat
    // @OneToMany if no cancellation
    @ManyToMany
    private List<ShowSeat> showSeats;

    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
