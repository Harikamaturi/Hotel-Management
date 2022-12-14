package com.reservation.service;

import java.util.List;

import com.reservation.exception.ReservationNotFoundException;
import com.reservation.model.Reservation;

public interface ReservationService {
	public List<Reservation > showAllReservationDetails()throws ReservationNotFoundException;
	public Reservation showReservationById(int id) throws ReservationNotFoundException;
	public Reservation addReservation(Reservation reservation) throws ReservationNotFoundException;
	public Reservation updateReservation(Reservation reservation)throws ReservationNotFoundException;
	public String deleteReservation(int id) throws ReservationNotFoundException;
}
