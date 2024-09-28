package me.vibhishanranga.bookmyshowdesign.dtos;

import lombok.Getter;
import lombok.Setter;
import me.vibhishanranga.bookmyshowdesign.models.City;

@Getter
@Setter
public class CreateCityResponseDto {
    private City city;
}
