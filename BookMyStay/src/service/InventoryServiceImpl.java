package service;

import model.RoomType;
import java.util.HashMap;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {

    private final Map<RoomType, Integer> roomCounts = new HashMap<>();

    public void addRoomType(RoomType type, int count, double price) {
        roomCounts.put(type, count);
    }

    public void updateRoomCount(RoomType type, int count) {
        roomCounts.put(type, count);
    }

    public Map<RoomType, Integer> getRoomCounts() {
        return new HashMap<>(roomCounts);
    }

    @Override
    public Map<RoomType, Double> getRoomPrices() {
        return Map.of();
    }
}