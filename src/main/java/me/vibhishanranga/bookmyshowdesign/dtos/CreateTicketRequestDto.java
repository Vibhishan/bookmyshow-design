package me.vibhishanranga.bookmyshowdesign.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateTicketRequestDto {
    private Long showId;
    private List<Long> showSeatIds;
    private Long userId;
}
