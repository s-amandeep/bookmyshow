package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateCustomerDTO;
import com.example.bookmyshow.exceptions.InvalidCustomerException;
import com.example.bookmyshow.models.Customer;
import com.example.bookmyshow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request){
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerDTO request) {
        if (request.getEmail() == null){
            throw new InvalidCustomerException();
        }
    }
}
