package service;

import exception.RoomNotFoundException;
import model.RoomInventory;
import model.RoomType;

import java.util.*;

public class InventoryServiceImpl implements InventoryService {

    private final Map<RoomType, RoomInventory> inventoryMap = new HashMap<>();

    @Override
    public void addRoomType(RoomType roomType, int count, double price) {
        inventoryMap.put(roomType, new RoomInventory(roomType, count, price));
    }

    @Override
    public void updateRoomCount(RoomType roomType, int newCount) {
        getRoom(roomType).setCount(newCount);
    }

    @Override
    public void updateRoomPrice(RoomType roomType, double newPrice) {
        getRoom(roomType).setPrice(newPrice);
    }

    @Override
    public RoomInventory getRoomDetails(RoomType roomType) {
        return getRoom(roomType);
    }

    @Override
    public List<RoomInventory> getAllRooms() {
        return new ArrayList<>(inventoryMap.values());
    }

    @Override
    public Map<RoomType, Double> getRoomPrices() {
        Map<RoomType, Double> prices = new HashMap<>();
        for (RoomInventory room : inventoryMap.values()) {
            prices.put(room.getRoomType(), room.getPrice());
        }
        return prices;
    }

    @Override
    public Map<RoomType, Integer> getRoomCounts() {
        Map<RoomType, Integer> counts = new HashMap<>();
        for (RoomInventory room : inventoryMap.values()) {
            counts.put(room.getRoomType(), room.getCount());
        }
        return counts;
    }

    private RoomInventory getRoom(RoomType type) {
        RoomInventory room = inventoryMap.get(type);
        if (room == null) {
            throw new RoomNotFoundException("Room not found: " + type);
        }
        return room;
    }
}