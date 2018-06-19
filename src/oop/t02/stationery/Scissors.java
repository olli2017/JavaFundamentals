package oop.t02.stationery;

public class Scissors extends Stationery {
    public Scissors(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
