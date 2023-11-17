package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateBookingDTO;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;
    @PostMapping
    public Booking createBooking(@RequestBody CreateBookingDTO request){
        return bookingService.createBooking(request);
    }
}
