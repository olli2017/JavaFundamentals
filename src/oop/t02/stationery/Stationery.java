package oop.t02.stationery;

public abstract class Stationery {
    int price;

    public Stationery(int price) {
        this.price = price;
    }

    public abstract int getPrice();
}
