package model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Reservation {

    private final String reservationId;
    private final RoomType roomType;
    private final int roomsRequested;

    // ✅ Assigned room IDs
    private final Set<String> allocatedRoomIds = new HashSet<>();

    public Reservation(RoomType roomType, int roomsRequested) {
        this.reservationId = UUID.randomUUID().toString();
        this.roomType = roomType;
        this.roomsRequested = roomsRequested;
    }

    public String getReservationId() {
        return reservationId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getRoomsRequested() {
        return roomsRequested;
    }

    public Set<String> getAllocatedRoomIds() {
        return allocatedRoomIds;
    }
}