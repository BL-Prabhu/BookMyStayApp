package model;

import java.util.UUID;

/**
 * Represents a booking request.
 */
public class Reservation {

    private final String reservationId;
    private final RoomType roomType;
    private final int roomsRequested;

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
}