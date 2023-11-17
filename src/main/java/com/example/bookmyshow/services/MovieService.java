package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.CreateMovieDTO;
import com.example.bookmyshow.exceptions.MovieNotFoundException;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    public Movie getMovie(Long id) {
        return movieRepository
                .findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id: " + id + "does not exist"));
    }

    public Movie createMovie(Movie movie) {

        return movieRepository.save(movie);
    }
}
