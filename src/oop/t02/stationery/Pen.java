package oop.t02.stationery;

public class Pen extends Stationery {
    public Pen(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
