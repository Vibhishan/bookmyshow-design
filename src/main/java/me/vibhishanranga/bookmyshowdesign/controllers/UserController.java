package me.vibhishanranga.bookmyshowdesign.controllers;

import me.vibhishanranga.bookmyshowdesign.dtos.CreateUserRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateUserResponseDto;
import me.vibhishanranga.bookmyshowdesign.models.User;
import me.vibhishanranga.bookmyshowdesign.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// if a class is annotated this way, spring will create a controller instance without us manually creating one
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public CreateUserResponseDto createuser(CreateUserRequestDto request){
        User savedUser = userService.createUser(request.getEmail());

        CreateUserResponseDto response = new CreateUserResponseDto();
        response.setUser(savedUser);
        return response;
    }
}
