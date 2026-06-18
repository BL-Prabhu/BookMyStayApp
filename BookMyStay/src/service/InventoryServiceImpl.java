package service;

import exception.RoomNotFoundException;
import model.RoomInventory;
import model.RoomType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Thread-safe implementation of InventoryService.
 */
public class InventoryServiceImpl implements InventoryService {

    private final Map<RoomType, RoomInventory> inventoryMap = new ConcurrentHashMap<>();

    @Override
    public void addRoomType(RoomType roomType, int count, double price) {
        inventoryMap.put(roomType, new RoomInventory(roomType, count, price));
    }

    @Override
    public void updateRoomCount(RoomType roomType, int newCount) {
        RoomInventory inventory = getInventoryOrThrow(roomType);
        inventory.updateCount(newCount);
    }

    @Override
    public void updateRoomPrice(RoomType roomType, double newPrice) {
        RoomInventory inventory = getInventoryOrThrow(roomType);
        inventory.updatePrice(newPrice);
    }

    @Override
    public RoomInventory getRoomDetails(RoomType roomType) {
        return getInventoryOrThrow(roomType);
    }

    @Override
    public List<RoomInventory> getAllRooms() {
        return new ArrayList<>(inventoryMap.values());
    }

    private RoomInventory getInventoryOrThrow(RoomType roomType) {
        RoomInventory inventory = inventoryMap.get(roomType);
        if (inventory == null) {
            throw new RoomNotFoundException("Room type not found: " + roomType);
        }
        return inventory;
    }
}