package me.vibhishanranga.bookmyshowdesign.services;

import me.vibhishanranga.bookmyshowdesign.models.City;
import me.vibhishanranga.bookmyshowdesign.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City addCity(String name){
        City city = new City();
        city.setName(name);

        City savedCity = cityRepository.save(city);
        return savedCity;
    }
}
