package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long hallId) {
        return seatRepository.findAllByScreen_Id(hallId);
    }
}
