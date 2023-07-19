package com.reserve.tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.reserve.tables.service.ReservationService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public String reserveTable(@RequestParam("date") String date,
                               @RequestParam("partySize") int partySize) {
        LocalDate reservationDate = LocalDate.parse(date);
        return reservationService.reserveTable(reservationDate, partySize);
    }

    @GetMapping("/{date}")
    public String checkAvailability(@PathVariable("date") String date) {
        LocalDate reservationDate = LocalDate.parse(date);
        return reservationService.checkAvailability(reservationDate);
    }
}
