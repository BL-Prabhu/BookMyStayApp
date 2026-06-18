package com.bookmystay;

import controller.BookingController;
import model.RoomType;
import service.*;

public class BookMyStayApplication {

    public static void main(String[] args) {

        // ✅ Setup Inventory
        InventoryService inventoryService = new InventoryServiceImpl();
        inventoryService.addRoomType(RoomType.SINGLE, 2, 1000);
        inventoryService.addRoomType(RoomType.DOUBLE, 1, 2000);

        // ✅ Setup Booking System
        BookingService bookingService = new BookingServiceImpl(inventoryService);
        BookingController controller = new BookingController(bookingService);

        // ✅ Simulate multiple booking requests (FCFS)
        controller.book(RoomType.SINGLE, 1); // success
        controller.book(RoomType.SINGLE, 1); // success
        controller.book(RoomType.SINGLE, 1); // fail (no rooms left)
        controller.book(RoomType.DOUBLE, 1); // success
        controller.book(RoomType.DOUBLE, 1); // fail

        System.out.println("\nProcessing bookings...\n");

        // ✅ Process queue
        controller.process();
    }
}