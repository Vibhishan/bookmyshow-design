package me.vibhishanranga.bookmyshowdesign.services;

import me.vibhishanranga.bookmyshowdesign.exceptions.CityNotFoundException;
import me.vibhishanranga.bookmyshowdesign.models.*;
import me.vibhishanranga.bookmyshowdesign.repositories.AuditoriumRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.CityRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.SeatRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;
    private SeatRepository seatRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository,
                          CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository,
                          SeatRepository seatRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
    }

    public Theatre createTheatre(String name, String address, Long id) throws CityNotFoundException {
        // check if city with ID exists
        Optional<City> cityOptional = cityRepository.findById(id);
        if(!cityOptional.isPresent()){
            throw new CityNotFoundException("No city with given ID");
        }

        // create theatre object
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);

        // save it to database
        Theatre savedTheatre = theatreRepository.save(theatre);

        // fetch the city for the ID
        City dbCity = cityOptional.get();

        // add the theatre to the city
        dbCity.getTheatres().add(savedTheatre);

        // update the city in the database
        // according to JPA, if we try to save what is already existing, it will update
        this.cityRepository.save(dbCity);

        return savedTheatre;
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity){
        Theatre theatre = theatreRepository.findById(theatreId).get();

        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);

        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);

        theatre.getAuditoriums().add(savedAuditorium);

        return theatreRepository.save(theatre);
    }

    public void addSeatsToAuditorium(Long auditoriumId, Map<SeatType, Integer> seatCount){
        Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();

        List<Seat> seats = new ArrayList<>();

        for(Map.Entry<SeatType, Integer> entry: seatCount.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                Seat seat = new Seat();
                seat.setSeatType(entry.getKey());
                seat.setSeatNumber(entry.getKey().toString() + (i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = new ArrayList<>();

        for(Seat seat: seats){
            savedSeats.add(seatRepository.save(seat));
        }

        auditorium.setSeats(savedSeats);

        auditoriumRepository.save(auditorium);
    }
}
