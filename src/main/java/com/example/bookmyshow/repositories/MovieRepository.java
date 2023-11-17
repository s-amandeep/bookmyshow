package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
