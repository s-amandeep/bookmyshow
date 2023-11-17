package com.example.bookmyshow.models;

import com.example.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();
    //    private Theatre theatre;

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;
    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
