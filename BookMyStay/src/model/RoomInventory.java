package model;

public class RoomInventory {

    private RoomType roomType;
    private int count;
    private double price;

    public RoomInventory(RoomType roomType, int count, double price) {
        this.roomType = roomType;
        this.count = count;
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomInventory{" +
                "roomType=" + roomType +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}