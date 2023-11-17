package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.CreateScreenDTO;
import com.example.bookmyshow.dtos.SeatPosition;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.models.Screen;
import com.example.bookmyshow.models.Seat;
import com.example.bookmyshow.repositories.ScreenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ScreenService {
    private ScreenRepository screenRepository;
    private SeatService seatService;

    public Screen getScreen(Long screenId) {
        return screenRepository.findById(screenId)
                .orElse(null);
    }

    public static List<Seat> toSeats(Screen screen, Map<SeatType, List<SeatPosition>> seatPositions) {

        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNo(seatPosition.getRowNo())
                                    .columnNo(seatPosition.getColumnNo())
                                    .screen(screen)
                                    .build());
        }).toList();
    }

    public Screen createScreen(CreateScreenDTO request){

        Screen initialScreenRequest = Screen.builder()
                .features(request.getFeatures())
                .name(request.getName())
                .build();

        Screen initialScreen = screenRepository.save(initialScreenRequest);

        List<Seat> seats = toSeats(initialScreen, request.getSeatRanges());
        List<Seat> savedSeats = seatService.saveAll(seats);

        return screenRepository.save(initialScreen.toBuilder().seats(savedSeats).build());
    }
}
