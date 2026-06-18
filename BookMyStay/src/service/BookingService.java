package service;

import model.Reservation;

public interface BookingService {

    void requestBooking(Reservation reservation);

    void processBookings();
}