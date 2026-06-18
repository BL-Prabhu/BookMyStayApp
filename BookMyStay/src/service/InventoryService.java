package service;

import model.RoomType;
import java.util.Map;

public interface InventoryService {
    void addRoomType(RoomType type, int count, double price);
    void updateRoomCount(RoomType type, int count);
    Map<RoomType, Integer> getRoomCounts();

    Map<RoomType, Double> getRoomPrices();
}