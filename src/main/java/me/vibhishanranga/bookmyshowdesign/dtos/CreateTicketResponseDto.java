package me.vibhishanranga.bookmyshowdesign.dtos;

import lombok.Getter;
import lombok.Setter;
import me.vibhishanranga.bookmyshowdesign.models.Ticket;

@Getter
@Setter
public class CreateTicketResponseDto {
    private Ticket ticket;
}
