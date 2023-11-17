package com.example.bookmyshow.dtos;

import com.example.bookmyshow.enums.BookingStatus;
import com.example.bookmyshow.models.Customer;
import com.example.bookmyshow.models.Payment;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CreateBookingDTO {
    private Long customerId;
    private Long showId;
    private List<Long> showSeatsId = new ArrayList<>();
}
