package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateShowDTO;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    @GetMapping("/{id}")
    public Show getShow(@PathVariable Long id){
        return showService.getShow(id);
    }

    @PostMapping
    public Show createShow(@RequestBody CreateShowDTO request){
        return showService.createShow(request);
    }
}
