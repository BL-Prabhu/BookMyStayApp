package service;

import model.RoomInventory;
import model.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchServiceImpl implements SearchService {

    private final InventoryService inventoryService;

    public SearchServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public List<RoomInventory> searchAvailableRooms() {

        Map<RoomType, Integer> counts = inventoryService.getRoomCounts();
        Map<RoomType, Double> prices = inventoryService.getRoomPrices();

        List<RoomInventory> result = new ArrayList<>();

        for (RoomType type : counts.keySet()) {
            if (counts.get(type) > 0) {
                result.add(new RoomInventory(type, counts.get(type), prices.get(type)));
            }
        }

        return result; // ✅ No exception
    }
}