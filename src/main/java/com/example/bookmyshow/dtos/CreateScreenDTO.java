package com.example.bookmyshow.dtos;

import com.example.bookmyshow.enums.MovieFeature;
import com.example.bookmyshow.enums.SeatType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateScreenDTO {
    private String name;
//    private List<Seat> seats = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRanges = new HashMap<>();
    private List<MovieFeature> features = new ArrayList<>();
}
