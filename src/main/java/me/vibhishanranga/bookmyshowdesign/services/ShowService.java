package me.vibhishanranga.bookmyshowdesign.services;

import me.vibhishanranga.bookmyshowdesign.models.*;
import me.vibhishanranga.bookmyshowdesign.repositories.AuditoriumRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.ShowRepository;
import me.vibhishanranga.bookmyshowdesign.repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {
    private AuditoriumRepository auditoriumRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowService(AuditoriumRepository auditoriumRepository,
                       ShowRepository showRepository,
                       ShowSeatRepository showSeatRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Show createShow(Long movieId, Date startTime, Date endTime, Long auditoriumId,
                           Map<SeatType, Integer> seatPricing, Language language){
        Show show = new Show();
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setLanguage(language);

        Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();
        show.setAuditorium(auditorium);

        Show savedShow = showRepository.save(show);

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for(Seat seat: auditorium.getSeats()){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(savedShow);
            showSeat.setSeat(seat);
            showSeat.setState(ShowSeatState.AVAILABLE);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        savedShow.setShowSeats(savedShowSeats);

        return savedShow;
    }
}
