package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    public List<Seat> findAllByScreen_Id(Long screen_id);
}
