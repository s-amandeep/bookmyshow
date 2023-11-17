package com.example.bookmyshow.strategies;

import com.example.bookmyshow.BookmyshowApplication;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ShowSeat;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
