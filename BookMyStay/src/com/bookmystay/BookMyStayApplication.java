package com.bookmystay;

import controller.InventoryController;
import controller.SearchController;
import model.RoomType;
import service.*;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryServiceImpl();
        SearchService searchService = new SearchServiceImpl(inventoryService);

        InventoryController inventoryController = new InventoryController(inventoryService);
        SearchController searchController = new SearchController(searchService);

        // UC1
        inventoryController.addRoom(RoomType.SINGLE, 5, 1200);
        inventoryController.addRoom(RoomType.DOUBLE, 3, 2000);
        inventoryController.addRoom(RoomType.SUITE, 1, 5000);

        // UC2
        searchController.searchRooms();
    }
}