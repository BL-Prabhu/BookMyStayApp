package service;

import model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingHistoryServiceImpl implements BookingHistoryService {

    private final List<Reservation> history = new ArrayList<>();

    @Override
    public void addReservation(Reservation reservation) {
        reservation.setStatus("CONFIRMED");
        history.add(reservation);
    }

    @Override
    public void cancelReservation(String reservationId) {
        Optional<Reservation> res = history.stream()
                .filter(r -> r.getReservationId().equals(reservationId))
                .findFirst();

        res.ifPresent(r -> r.setStatus("CANCELLED"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(history);
    }

    @Override
    public void generateReport() {
        System.out.println("\n===== BOOKING REPORT =====");

        for (Reservation r : history) {
            System.out.println(
                    r.getReservationId() +
                            " | " + r.getRoomType() +
                            " | Rooms: " + r.getRoomsRequested() +
                            " | Status: " + r.getStatus() +
                            " | Time: " + r.getCreatedAt()
            );
        }
    }
}