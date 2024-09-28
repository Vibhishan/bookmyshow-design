package me.vibhishanranga.bookmyshowdesign.dtos;

import lombok.Getter;
import lombok.Setter;
import me.vibhishanranga.bookmyshowdesign.models.User;

@Getter
@Setter
public class CreateUserResponseDto {
    private User user;
}
