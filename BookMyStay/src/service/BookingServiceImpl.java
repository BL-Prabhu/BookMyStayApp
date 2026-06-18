package service;

import model.Reservation;

import java.util.LinkedList;
import java.util.Queue;

public class BookingServiceImpl implements BookingService {

    private final InventoryService inventory;
    private final BookingHistoryService historyService;

    private final Queue<Reservation> queue = new LinkedList<>();

    public BookingServiceImpl(InventoryService inventory,
                              BookingHistoryService historyService) {
        this.inventory = inventory;
        this.historyService = historyService;
    }

    @Override
    public void requestBooking(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added: " + reservation.getReservationId());
    }

    @Override
    public void processBookings() {
        while (!queue.isEmpty()) {
            Reservation r = queue.poll();

            try {
                // Simulate success booking
                r.setStatus("CONFIRMED");

                // Save to history
                historyService.addReservation(r);

                System.out.println("BOOKED: " + r.getReservationId());

            } catch (Exception e) {
                r.setStatus("FAILED");
                System.out.println("FAILED: " + r.getReservationId());
            }
        }
    }
}