package me.vibhishanranga.bookmyshowdesign.repositories;

import me.vibhishanranga.bookmyshowdesign.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
