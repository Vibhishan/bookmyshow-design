package me.vibhishanranga.bookmyshowdesign.repositories;

import me.vibhishanranga.bookmyshowdesign.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    City save(City name);

    Optional<City> findById(Long id);
}
