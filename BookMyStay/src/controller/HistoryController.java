package controller;

import service.BookingHistoryService;

public class HistoryController {

    private final BookingHistoryService service;

    public HistoryController(BookingHistoryService service) {
        this.service = service;
    }

    public void cancel(String reservationId) {
        service.cancelReservation(reservationId);
        System.out.println("Cancelled: " + reservationId);
    }

    public void report() {
        service.generateReport();
    }
}