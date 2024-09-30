package me.vibhishanranga.bookmyshowdesign.controllers;

import me.vibhishanranga.bookmyshowdesign.dtos.CreateShowRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateShowResponseDto;
import me.vibhishanranga.bookmyshowdesign.models.Show;
import me.vibhishanranga.bookmyshowdesign.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {
    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService){
        this.showService = showService;
    }

    public CreateShowResponseDto createShow(CreateShowRequestDto request){
        Show savedShow = showService.createShow(request.getMovieId(), request.getStartTime(), request.getEndTime(),
                request.getAuditoriumId(), request.getSeatPrices(), request.getLanguage());

        CreateShowResponseDto responseDto = new CreateShowResponseDto();
        responseDto.setShow(savedShow);

        return responseDto;
    }
}
