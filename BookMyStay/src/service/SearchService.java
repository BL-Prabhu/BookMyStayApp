package service;

import model.RoomInventory;
import java.util.List;

public interface SearchService {
    List<RoomInventory> searchAvailableRooms();
}