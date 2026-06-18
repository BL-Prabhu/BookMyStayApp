package com.bookmystay;

import controller.BookingController;
import model.RoomType;
import service.*;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryServiceImpl();

        inventory.addRoomType(RoomType.SINGLE, 2, 1000);
        inventory.addRoomType(RoomType.DOUBLE, 1, 2000);

        BookingService bookingService = new BookingServiceImpl(inventory);
        BookingController controller = new BookingController(bookingService);

        controller.book(RoomType.SINGLE, 1);
        controller.book(RoomType.SINGLE, 1);
        controller.book(RoomType.SINGLE, 1); // fail
        controller.book(RoomType.DOUBLE, 1);
        controller.book(RoomType.DOUBLE, 1); // fail

        System.out.println("\nProcessing bookings...\n");

        controller.process();
    }
}