package oop.t02.stationery;

public class Corrector extends Stationery {
    public Corrector(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
