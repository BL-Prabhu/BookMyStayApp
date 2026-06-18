package controller;

import model.RoomInventory;
import service.SearchService;

import java.util.List;

public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    public void searchRooms() {
        List<RoomInventory> rooms = service.searchAvailableRooms();

        if (rooms.isEmpty()) {
            System.out.println("❌ No rooms available");
        } else {
            System.out.println("✅ Available Rooms:");
            rooms.forEach(System.out::println);
        }
    }
}