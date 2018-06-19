package oop.t02.stationery;

public class Pencil extends Stationery {
    public Pencil(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
