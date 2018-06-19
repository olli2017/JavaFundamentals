package oop.t02.stationery;

public class Eraser extends Stationery {
    public Eraser(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
