package me.vibhishanranga.bookmyshowdesign.services;

import me.vibhishanranga.bookmyshowdesign.exceptions.CityNotFoundException;
import me.vibhishanranga.bookmyshowdesign.models.Auditorium;
import me.vibhishanranga.bookmyshowdesign.models.City;
import me.vibhishanranga.bookmyshowdesign.models.Theatre;
import me.vibhishanranga.bookmyshowdesign.repositories.AuditoriumRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.CityRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository,
                          CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository){
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
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
}
