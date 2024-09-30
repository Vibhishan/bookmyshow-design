package me.vibhishanranga.bookmyshowdesign.dtos;

import lombok.Getter;
import lombok.Setter;
import me.vibhishanranga.bookmyshowdesign.models.Show;

@Getter
@Setter
public class CreateShowResponseDto {
    private Show show;
}
