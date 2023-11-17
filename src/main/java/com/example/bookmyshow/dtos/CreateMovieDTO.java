package com.example.bookmyshow.dtos;

import com.example.bookmyshow.enums.Language;
import com.example.bookmyshow.enums.MovieFeature;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.models.Show;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor
@Getter
public class CreateMovieDTO {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie() {
        Movie movie = Movie.builder()
                .name(name)
                .rating(rating)
                .languages(languages)
                .features(features)
                .build();

        return movie;
    }
}