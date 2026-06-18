package service;

import exception.NoAvailableRoomException;
import model.Reservation;
import model.RoomType;

import java.util.*;

public class BookingServiceImpl implements BookingService {

    private final Queue<Reservation> queue = new LinkedList<>();
    private final InventoryService inventory;
    private final RoomAllocator allocator = new RoomAllocator();

    public BookingServiceImpl(InventoryService inventory) {
        this.inventory = inventory;
    }

    @Override
    public void requestBooking(Reservation r) {
        queue.offer(r);
        System.out.println("Request added: " + r.getReservationId());
    }

    @Override
    public void processBookings() {
        while (!queue.isEmpty()) {
            Reservation r = queue.poll();

            try {
                confirm(r);
                System.out.println("BOOKED: " + r.getReservationId()
                        + " Rooms: " + r.getAllocatedRoomIds());
            } catch (Exception e) {
                System.out.println("FAILED: " + r.getReservationId() + " -> " + e.getMessage());
            }
        }
    }

    private void confirm(Reservation r) {
        Map<RoomType, Integer> counts = inventory.getRoomCounts();

        int available = counts.getOrDefault(r.getRoomType(), 0);

        if (available < r.getRoomsRequested()) {
            throw new NoAvailableRoomException("Not enough rooms available");
        }

        // Allocate unique rooms
        Set<String> rooms = allocator.allocate(r.getRoomType(), r.getRoomsRequested());
        r.getAllocatedRoomIds().addAll(rooms);

        // Update inventory
        inventory.updateRoomCount(r.getRoomType(), available - r.getRoomsRequested());
    }
}