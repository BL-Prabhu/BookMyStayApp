package service;

import model.RoomType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Allocates unique room IDs (prevents duplicates)
 */
public class RoomAllocator {

    private final Set<String> usedRoomIds = new HashSet<>();

    public Set<String> allocate(RoomType type, int count) {
        Set<String> allocated = new HashSet<>();

        while (allocated.size() < count) {
            String roomId = type.name() + "-" + UUID.randomUUID().toString().substring(0, 5);

            if (!usedRoomIds.contains(roomId)) {
                usedRoomIds.add(roomId);
                allocated.add(roomId);
            }
        }

        return allocated;
    }
}