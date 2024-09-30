package me.vibhishanranga.bookmyshowdesign.repositories;

import me.vibhishanranga.bookmyshowdesign.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
