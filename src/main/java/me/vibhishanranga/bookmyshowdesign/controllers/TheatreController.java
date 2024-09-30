package me.vibhishanranga.bookmyshowdesign.controllers;

import me.vibhishanranga.bookmyshowdesign.dtos.CreateTheatreRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateTheatreResponseDto;
import me.vibhishanranga.bookmyshowdesign.exceptions.CityNotFoundException;
import me.vibhishanranga.bookmyshowdesign.models.Theatre;
import me.vibhishanranga.bookmyshowdesign.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    public CreateTheatreResponseDto createTheatre(CreateTheatreRequestDto request, Long id)
            throws CityNotFoundException {
        Theatre savedTheatre = null;
        CreateTheatreResponseDto response = new CreateTheatreResponseDto();
        try {
            savedTheatre = theatreService.createTheatre(request.getName(), request.getAddress(), id);
            response.setTheatre(savedTheatre);

        } catch (CityNotFoundException exception){
            System.out.println("Something went wrong");
        }

        return response;
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity){
        return theatreService.addAuditorium(theatreId, name, capacity);
    }
}
