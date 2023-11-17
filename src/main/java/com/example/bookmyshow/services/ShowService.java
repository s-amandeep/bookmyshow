package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.CreateShowDTO;
import com.example.bookmyshow.exceptions.InvalidShowException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowService {
    private ShowRepository showRepository;
    private MovieService movieService;
    private ScreenService screenService;
    private SeatService seatService;
//    private ShowSeatRepository showSeatRepository;
    private ShowSeatService showSeatService;

    public Show getShow(Long id) {
        return showRepository
                .findById(id)
                .orElseThrow(() -> new InvalidShowException("No show with id: " + id + " exists."));
    }

    public Show createShow(CreateShowDTO request) {
        Movie movie = movieService.getMovie(request.getMovieId());
        Screen screen = screenService.getScreen(request.getScreenId());

        Show show = Show.builder()
                .movie(movie)
                .screen(screen)
                .duration(request.getDuration())
                .startTime(request.getStartTime())
                .build();

        Show savedShow = showRepository.save(show);

        // Get seats in the Screen using ScreenId
        // Create the showSeats using the savedShow
        List<Seat> seats = seatService.getAll(request.getScreenId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(savedShow)
                        .build()).toList();


        List<ShowSeat> savedShowSeats = showSeatService.saveAll(showSeats);

        // Save the show again
        return showRepository.save(savedShow.toBuilder().showSeats(savedShowSeats).build());
    }
}
