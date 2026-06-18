package service;

import model.RoomInventory;
import model.RoomType;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    void addRoomType(RoomType roomType, int count, double price);

    void updateRoomCount(RoomType roomType, int newCount);

    void updateRoomPrice(RoomType roomType, double newPrice);

    RoomInventory getRoomDetails(RoomType roomType);

    List<RoomInventory> getAllRooms();

    Map<RoomType, Double> getRoomPrices();

    Map<RoomType, Integer> getRoomCounts();
}