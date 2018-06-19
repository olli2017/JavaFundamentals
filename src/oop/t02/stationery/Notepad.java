package oop.t02.stationery;

public class Notepad extends Stationery {
    public Notepad(int price) {
        super(price);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
