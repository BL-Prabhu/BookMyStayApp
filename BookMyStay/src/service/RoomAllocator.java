package service;

import model.RoomType;

import java.util.*;

/**
 * Handles room allocation with uniqueness guarantee.
 */
public class RoomAllocator {

    // ✅ Prevent duplicate room IDs
    private final Set<String> bookedRoomIds = new HashSet<>();

    // ✅ RoomType → Assigned Room IDs
    private final Map<RoomType, Set<String>> allocatedRooms = new HashMap<>();

    /**
     * Allocate unique rooms
     */
    public Set<String> allocate(RoomType type, int count) {

        Set<String> assignedRooms = new HashSet<>();

        for (int i = 0; i < count; i++) {

            String roomId;

            // ✅ Ensure unique room ID
            do {
                roomId = type.name() + "-" + UUID.randomUUID().toString().substring(0, 5);
            } while (bookedRoomIds.contains(roomId));

            bookedRoomIds.add(roomId);
            assignedRooms.add(roomId);
        }

        allocatedRooms
                .computeIfAbsent(type, k -> new HashSet<>())
                .addAll(assignedRooms);

        return assignedRooms;
    }

    public Map<RoomType, Set<String>> getAllocatedRooms() {
        return allocatedRooms;
    }
}