package controller;

import model.Reservation;
import model.RoomType;
import service.BookingService;

/**
 * Controller for booking requests.
 */
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void book(RoomType type, int count) {
        Reservation reservation = new Reservation(type, count);
        bookingService.requestBooking(reservation);
    }

    public void process() {
        bookingService.processBookings();
    }
}