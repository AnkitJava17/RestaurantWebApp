package com.reserve.tables.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.tables.model.Reservation;
import com.reserve.tables.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public String reserveTable(LocalDate date, int partySize) {
        Optional<Reservation> existingReservation = reservationRepository.findByDate(date);
        if (existingReservation.isPresent()) {
            return "Table already reserved for " + date;
        } else {
            Reservation reservation = new Reservation();
            reservation.setDate(date);
            reservation.setPartySize(partySize);
            reservationRepository.save(reservation);
            return "Table reserved for " + date;
        }
    }

    public String checkAvailability(LocalDate date) {
        Optional<Reservation> existingReservation = reservationRepository.findByDate(date);
        if (existingReservation.isPresent()) {
            return "Table not available for " + date;
        } else {
            return "Table available for " + date;
        }
    }
	
    
}
