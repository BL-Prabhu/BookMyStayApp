package model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Reservation {

    private static int counter = 1;

    private String reservationId;
    private RoomType roomType;
    private int roomsRequested;
    private Set<String> allocatedRoomIds = new HashSet<>();

    private String status;
    private LocalDateTime createdAt;

    public Reservation(RoomType roomType, int roomsRequested) {
        this.reservationId = "RES" + counter++;
        this.roomType = roomType;
        this.roomsRequested = roomsRequested;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public String getReservationId() { return reservationId; }
    public RoomType getRoomType() { return roomType; }
    public int getRoomsRequested() { return roomsRequested; }
    public Set<String> getAllocatedRoomIds() { return allocatedRoomIds; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}