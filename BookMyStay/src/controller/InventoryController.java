package controller;

import model.RoomType;
import service.InventoryService;

public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    public void addRoom(RoomType type, int count, double price) {
        service.addRoomType(type, count, price);
        System.out.println("Room added: " + type);
    }
}