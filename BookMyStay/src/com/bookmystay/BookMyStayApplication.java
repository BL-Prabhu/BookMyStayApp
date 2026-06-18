package com.bookmystay;

import controller.BookingController;
import model.RoomType;
import service.*;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryServiceImpl();

        // Setup rooms
        inventory.addRoomType(RoomType.SINGLE, 2, 1000);
        inventory.addRoomType(RoomType.DOUBLE, 1, 2000);

        BookingController controller =
                new BookingController(new BookingServiceImpl(inventory));

        // Requests (FIFO Queue)
        controller.book(RoomType.SINGLE, 1);
        controller.book(RoomType.SINGLE, 2); // will fail
        controller.book(RoomType.DOUBLE, 1);

        System.out.println("\nProcessing...\n");

        controller.process();
    }
}