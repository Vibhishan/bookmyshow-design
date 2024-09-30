package me.vibhishanranga.bookmyshowdesign;

import me.vibhishanranga.bookmyshowdesign.controllers.CityController;
import me.vibhishanranga.bookmyshowdesign.controllers.TheatreController;
import me.vibhishanranga.bookmyshowdesign.controllers.UserController;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateCityRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateTheatreRequestDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateTheatreResponseDto;
import me.vibhishanranga.bookmyshowdesign.dtos.CreateUserRequestDto;
import me.vibhishanranga.bookmyshowdesign.models.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BookmyshowDesignApplication implements CommandLineRunner {
    private UserController userController;
    private CityController cityController;
    private TheatreController theatreController;

    @Autowired
    public BookmyshowDesignApplication(UserController userController,
                                       CityController cityController,
                                       TheatreController theatreController){
        this.userController = userController;
        this.cityController = cityController;
        this.theatreController = theatreController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowDesignApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        // creating a user
        CreateUserRequestDto requestDto = new CreateUserRequestDto();
        requestDto.setEmail("test_user@gmail.com");
        this.userController.createUser(requestDto);

        // adding a city
        CreateCityRequestDto createCityRequestDto = new CreateCityRequestDto();
        createCityRequestDto.setName("Delhi");
        this.cityController.addCity(createCityRequestDto);

        // adding a theatre
        CreateTheatreRequestDto createTheatreRequestDto = new CreateTheatreRequestDto();
        createTheatreRequestDto.setName("PVR Cinemas");
        createTheatreRequestDto.setAddress("DLF Saket, Delhi");
        this.theatreController.createTheatre(createTheatreRequestDto, 1L);

        this.theatreController.addAuditorium(1L, "Audi 1", 120);

        Map<SeatType, Integer> seatsForAuditorium = new HashMap<>();
        seatsForAuditorium.put(SeatType.VIP, 20);
        seatsForAuditorium.put(SeatType.GOLD, 100);

        this.theatreController.addSeatsToAuditorium(1L, seatsForAuditorium);
    }
}
