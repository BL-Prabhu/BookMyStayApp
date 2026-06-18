package controller;

import model.Reservation;
import model.RoomType;
import service.BookingService;

public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    public void book(RoomType type, int count) {
        service.requestBooking(new Reservation(type, count));
    }

    public void process() {
        service.processBookings();
    }
}