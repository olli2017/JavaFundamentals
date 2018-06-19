package oop.t02;

import oop.t02.stationery.Stationery;

public class Employe {
    private Stationery[] stationeries;
    private int index;
    private int totalPrice;

    public Employe(int capacity) {
        stationeries = new Stationery[capacity];
    }

    public Employe() {
        this(200);
    }

    public Employe addStationeries(Stationery stationery) {
        stationeries[index++] = stationery;
        totalPrice += stationery.getPrice();
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}