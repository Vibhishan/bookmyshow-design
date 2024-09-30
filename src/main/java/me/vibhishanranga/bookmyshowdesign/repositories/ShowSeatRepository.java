package me.vibhishanranga.bookmyshowdesign.repositories;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import me.vibhishanranga.bookmyshowdesign.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value = "30000")
    })
    List<ShowSeat> findByIdIn(List<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);
}
