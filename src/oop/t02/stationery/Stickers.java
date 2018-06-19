package oop.t02.stationery;

public class Stickers extends Stationery {
    public Stickers(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
