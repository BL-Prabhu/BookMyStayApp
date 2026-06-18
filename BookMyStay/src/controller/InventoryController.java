package controller;


import model.RoomType;
import service.InventoryService;

/**
 * Controller to handle Use Case 1 flow.
 */
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void handleAddRoom(RoomType roomType, int count, double price) {
        inventoryService.addRoomType(roomType, count, price);
        System.out.println("Added: " + roomType);
    }

    public void handleUpdateRoomCount(RoomType roomType, int newCount) {
        inventoryService.updateRoomCount(roomType, newCount);
        System.out.println("Updated count: " + roomType);
    }

    public void handleUpdateRoomPrice(RoomType roomType, double newPrice) {
        inventoryService.updateRoomPrice(roomType, newPrice);
        System.out.println("Updated price: " + roomType);
    }

    public void handleGetRoomDetails(RoomType roomType) {
        System.out.println(inventoryService.getRoomDetails(roomType));
    }

    public void handleGetAllRooms() {
        inventoryService.getAllRooms().forEach(System.out::println);
    }
}