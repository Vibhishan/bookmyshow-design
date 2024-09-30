package me.vibhishanranga.bookmyshowdesign;

import me.vibhishanranga.bookmyshowdesign.controllers.*;
import me.vibhishanranga.bookmyshowdesign.dtos.*;
import me.vibhishanranga.bookmyshowdesign.models.Language;
import me.vibhishanranga.bookmyshowdesign.models.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BookmyshowDesignApplication implements CommandLineRunner {
    private UserController userController;
    private CityController cityController;
    private TheatreController theatreController;
    private ShowController showController;
    private TicketController ticketController;

    @Autowired
    public BookmyshowDesignApplication(UserController userController,
                                       CityController cityController,
                                       TheatreController theatreController,
                                       ShowController showController,
                                       TicketController ticketController){
        this.userController = userController;
        this.cityController = cityController;
        this.theatreController = theatreController;
        this.showController = showController;
        this.ticketController = ticketController;
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

        // adding auditorium
        this.theatreController.addAuditorium(1L, "Audi 1", 120);

        // adding seats to auditorium
        Map<SeatType, Integer> seatsForAuditorium = new HashMap<>();
        seatsForAuditorium.put(SeatType.VIP, 20);
        seatsForAuditorium.put(SeatType.GOLD, 100);
        this.theatreController.addSeatsToAuditorium(1L, seatsForAuditorium);

        // creating a show
        CreateShowRequestDto createShowRequestDto = new CreateShowRequestDto();
        createShowRequestDto.setMovieId(0L);
        createShowRequestDto.setStartTime(new Date());
        createShowRequestDto.setEndTime(new Date());
        createShowRequestDto.setAuditoriumId(1L);
        createShowRequestDto.setSeatPrices(null);
        createShowRequestDto.setLanguage(Language.ENGLISH);
        this.showController.createShow(createShowRequestDto);

        // booking a ticket
        CreateTicketRequestDto createTicketRequestDto = new CreateTicketRequestDto();
        createTicketRequestDto.setShowId(1L);
        createTicketRequestDto.setUserId(1L);
        createTicketRequestDto.setShowSeatIds(List.of(43L,44L,45L));
        this.ticketController.bookTicket(createTicketRequestDto);

        // TODO: Change seats to different list with one common and notice that the seat unavailable exception is
        //  raised
    }
}
