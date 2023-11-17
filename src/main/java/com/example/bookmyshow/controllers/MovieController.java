package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateCustomerDTO;
import com.example.bookmyshow.dtos.CreateMovieDTO;
import com.example.bookmyshow.exceptions.InvalidCustomerException;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieDTO request){
//        return movieService.createMovie(request.toMovie());
        return movieService.createMovie(request.toMovie());
    }
}
