package service;

import exception.NoAvailableRoomException;
import model.Reservation;
import model.RoomType;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BookingServiceImpl implements BookingService {

    private final Queue<Reservation> bookingQueue = new LinkedList<>();
    private final InventoryService inventoryService;
    private final RoomAllocator roomAllocator = new RoomAllocator();

    public BookingServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public void requestBooking(Reservation reservation) {
        bookingQueue.offer(reservation);
        System.out.println("Request added: " + reservation.getReservationId());
    }

    @Override
    public void processBookings() {

        while (!bookingQueue.isEmpty()) {

            Reservation reservation = bookingQueue.poll();

            try {
                confirmBooking(reservation);

                System.out.println("✅ BOOKED: " + reservation.getReservationId()
                        + " Rooms: " + reservation.getAllocatedRoomIds());

            } catch (NoAvailableRoomException e) {
                System.out.println("❌ FAILED: " + reservation.getReservationId()
                        + " | " + e.getMessage());
            }
        }
    }

    /**
     * UC4 Core Logic
     */
    private void confirmBooking(Reservation reservation) {

        RoomType type = reservation.getRoomType();
        int requested = reservation.getRoomsRequested();

        Map<RoomType, Integer> counts = inventoryService.getRoomCounts();

        int available = counts.getOrDefault(type, 0);

        if (available < requested) {
            throw new NoAvailableRoomException("Not enough rooms for " + type);
        }

        // ✅ Allocate unique room IDs
        Set<String> assignedRooms = roomAllocator.allocate(type, requested);
        reservation.getAllocatedRoomIds().addAll(assignedRooms);

        // ✅ Update inventory immediately
        inventoryService.updateRoomCount(type, available - requested);
    }
}