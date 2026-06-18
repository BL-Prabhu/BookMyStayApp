package service;

import exception.NoAvailableRoomException;
import model.Reservation;
import model.RoomType;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Booking service using FIFO queue.
 */
public class BookingServiceImpl implements BookingService {

    private final Queue<Reservation> bookingQueue = new LinkedList<>();
    private final InventoryService inventoryService;

    public BookingServiceImpl(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Add booking request to queue
     */
    @Override
    public void requestBooking(Reservation reservation) {
        bookingQueue.offer(reservation);
        System.out.println("Request added to queue: " + reservation.getReservationId());
    }

    /**
     * Process bookings in FIFO order
     */
    @Override
    public void processBookings() {

        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();

            try {
                allocateRoom(reservation);
                System.out.println("Booking SUCCESS: " + reservation.getReservationId());
            } catch (NoAvailableRoomException e) {
                System.out.println("Booking FAILED: " + reservation.getReservationId()
                        + " | Reason: " + e.getMessage());
            }
        }
    }

    /**
     * Core allocation logic
     */
    private void allocateRoom(Reservation reservation) {

        RoomType type = reservation.getRoomType();
        int requested = reservation.getRoomsRequested();

        Map<RoomType, Integer> roomCounts = inventoryService.getRoomCounts();

        int available = roomCounts.getOrDefault(type, 0);

        if (available < requested) {
            throw new NoAvailableRoomException("Not enough rooms for " + type);
        }

        // Reduce inventory
        inventoryService.updateRoomCount(type, available - requested);
    }
}