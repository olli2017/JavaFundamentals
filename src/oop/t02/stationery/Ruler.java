package oop.t02.stationery;

public class Ruler extends Stationery {
    public Ruler(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
