package com.reserve.tables.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ReservationService {

    public String reserveTable(LocalDate date, int partySize);

    public String checkAvailability(LocalDate date);
}
