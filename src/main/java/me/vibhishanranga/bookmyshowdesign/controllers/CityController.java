package me.vibhishanranga.bookmyshowdesign.controllers;

import me.vibhishanranga.bookmyshowdesign.dtos.CreateCityRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateCityResponseDto;
import me.vibhishanranga.bookmyshowdesign.models.City;
import me.vibhishanranga.bookmyshowdesign.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    public CreateCityResponseDto addCity(CreateCityRequestDto request){
        City savedCity = cityService.addCity(request.getName());

        CreateCityResponseDto response = new CreateCityResponseDto();
        response.setCity(savedCity);

        return response;
    }
}
