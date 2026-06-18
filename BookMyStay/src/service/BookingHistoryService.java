package service;

import model.Reservation;
import java.util.List;

public interface BookingHistoryService {

    void addReservation(Reservation reservation);

    void cancelReservation(String reservationId);

    List<Reservation> getAllReservations();

    void generateReport();
}