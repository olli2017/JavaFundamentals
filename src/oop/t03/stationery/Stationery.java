package oop.t03.stationery;

public abstract class Stationery {
    int price;

    public Stationery(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
