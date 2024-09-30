package me.vibhishanranga.bookmyshowdesign.controllers;

import me.vibhishanranga.bookmyshowdesign.dtos.CreateTicketRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateTicketResponseDto;
import me.vibhishanranga.bookmyshowdesign.exceptions.ShowSeatNotAvailableException;
import me.vibhishanranga.bookmyshowdesign.models.Ticket;
import me.vibhishanranga.bookmyshowdesign.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public CreateTicketResponseDto bookTicket(CreateTicketRequestDto request) throws ShowSeatNotAvailableException {
        Ticket bookedTicket = null;
        CreateTicketResponseDto responseDto = new CreateTicketResponseDto();
        try{
            bookedTicket = ticketService.bookTicket(request.getShowId(), request.getShowSeatIds(), request.getUserId());
            responseDto.setTicket(bookedTicket);
        } catch (ShowSeatNotAvailableException exception){
            System.out.println("Show seat unavailable");
        }

        return responseDto;
    }
}
