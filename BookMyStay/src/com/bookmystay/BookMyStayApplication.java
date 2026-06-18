package com.bookmystay;

import controller.BookingController;
import controller.HistoryController;
import model.RoomType;
import service.*;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryServiceImpl();
        BookingHistoryService history = new BookingHistoryServiceImpl();

        inventory.addRoomType(RoomType.SINGLE, 2, 1000);

        BookingService bookingService =
                new BookingServiceImpl(inventory, history);

        BookingController bookingController =
                new BookingController(bookingService);

        HistoryController historyController =
                new HistoryController(history);

        // Bookings
        bookingController.book(RoomType.SINGLE, 1);
        bookingController.book(RoomType.SINGLE, 2);

        bookingController.process();

        // Cancel one booking
        historyController.cancel("RES1");

        // Report
        historyController.report();
    }
}