package com.example.bookmyshow.services;

import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }

    public List<ShowSeat> getShowSeats(List<Long> showSeatIds) {
        return showSeatRepository.findAllById(showSeatIds);
    }
}
