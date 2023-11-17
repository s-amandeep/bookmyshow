package com.example.bookmyshow.models;

import com.example.bookmyshow.enums.PaymentMode;
import com.example.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
//    private Booking booking;
    private String reference;
    @Enumerated
    private PaymentMode paymentMode;
    private Double amount;
    @Enumerated
    private PaymentStatus status;
}
