package dto;


import model.RoomType;

/**
 * DTO representing room search result.
 */
public class RoomSearchResponse {

    private RoomType roomType;
    private int availableCount;
    private double price;

    public RoomSearchResponse(RoomType roomType, int availableCount, double price) {
        this.roomType = roomType;
        this.availableCount = availableCount;
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "RoomSearchResponse{" +
                "roomType=" + roomType +
                ", availableCount=" + availableCount +
                ", price=" + price +
                '}';
    }
}