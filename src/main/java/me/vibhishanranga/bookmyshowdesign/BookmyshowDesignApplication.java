package me.vibhishanranga.bookmyshowdesign;

import me.vibhishanranga.bookmyshowdesign.controllers.UserController;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmyshowDesignApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowDesignApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        CreateUserRequestDto requestDto = new CreateUserRequestDto();
        requestDto.setEmail("test_user2@gmail.com");

        this.userController.createuser(requestDto);
    }
}
