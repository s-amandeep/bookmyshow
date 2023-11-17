package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.models.Screen;
import lombok.Data;

import java.util.Date;

@Data
public class CreateShowDTO {
    private Long movieId;
    private Date startTime;
    private Integer duration;
    private Long screenId;
}
