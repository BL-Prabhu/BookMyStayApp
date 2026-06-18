package com.bookmystay;

import controller.InventoryController;
import model.RoomType;
import service.InventoryService;
import service.InventoryServiceImpl;

/**
 * Entry point for Use Case 1 execution.
 */
public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryServiceImpl();
        InventoryController controller = new InventoryController(inventoryService);

        // Use Case Flow
        controller.handleAddRoom(RoomType.SINGLE, 10, 2000);
        controller.handleAddRoom(RoomType.DOUBLE, 5, 3500);

        controller.handleUpdateRoomCount(RoomType.SINGLE, 8);
        controller.handleUpdateRoomPrice(RoomType.DOUBLE, 3700);

        controller.handleGetRoomDetails(RoomType.SINGLE);
        controller.handleGetAllRooms();
    }
}