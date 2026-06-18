package model;

import java.util.Objects;

/**
 * Represents inventory details for a specific room type.
 */
public class RoomInventory {

    private final RoomType roomType;
    private int availableCount;
    private double pricePerNight;

    public RoomInventory(RoomType roomType, int availableCount, double pricePerNight) {
        this.roomType = roomType;
        this.availableCount = availableCount;
        this.pricePerNight = pricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void updateCount(int newCount) {
        this.availableCount = newCount;
    }

    public void updatePrice(double newPrice) {
        this.pricePerNight = newPrice;
    }

    @Override
    public String toString() {
        return "RoomInventory{" +
                "roomType=" + roomType +
                ", availableCount=" + availableCount +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomInventory)) return false;
        RoomInventory that = (RoomInventory) o;
        return roomType == that.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType);
    }
}